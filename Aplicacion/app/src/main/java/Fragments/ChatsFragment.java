package Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapter.UserAdapter;
import e.asus.whitedoc.R;
import model.Chat;
import model.Chatlist;
import model.User;


public class ChatsFragment extends Fragment {
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> mUser;
    FirebaseUser fuser;
    DatabaseReference reference;

    private List<Chatlist> usersList;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.fragment_chats,container,false);
            recyclerView=view.findViewById(R.id.recycler_view);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            fuser= FirebaseAuth.getInstance().getCurrentUser();
            usersList=new ArrayList<>();
            reference=FirebaseDatabase.getInstance().getReference("Chatlist").child(fuser.getUid());
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    usersList.clear();
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Chatlist chatlist=snapshot.getValue(Chatlist.class);
                        usersList.add(chatlist);
                    }
                    chatList();

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        return view;
    }

    private void chatList(){
        mUser= new ArrayList<>();
        reference=FirebaseDatabase.getInstance().getReference("Users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mUser.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    User user=snapshot.getValue(User.class);
                    for(Chatlist chatlist:usersList){
                        if(user.getEmail().equals(chatlist.getEmail())){
                            mUser.add(user);

                        }
                    }
                }
                userAdapter=new UserAdapter(getContext(),mUser);
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



}