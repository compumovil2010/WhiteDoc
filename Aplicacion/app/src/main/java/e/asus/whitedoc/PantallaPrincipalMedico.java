package e.asus.whitedoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PantallaPrincipalMedico extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal_medico);
    }
    public void actividadCitasProgramadas(View v) {
        /*Intent pantallaCalendario = new Intent(getApplicationContext(), DisponibilidadMedico.class);
        startActivity(pantallaCalendario);*/
        Toast.makeText(this, "Aun no hay pantalla para citas programadas", Toast.LENGTH_SHORT).show();
    }

    public void actividadPerfilMedico(View v) {
        Intent pantallaperfil = new Intent(getApplicationContext(), PerfilMedico.class);
        startActivity(pantallaperfil);
        //Toast.makeText(this, "Aun no hay pantalla perfil de medico", Toast.LENGTH_SHORT).show();
    }

    public void actividadPacientes(View v) {
        /*Intent pantallaPaciente = new Intent(getApplicationContext(), DetallePaciente.class);
        startActivity(pantallaPaciente);*/
        Toast.makeText(this, "Aun no hay pantalla de listado de pacientes", Toast.LENGTH_SHORT).show();
    }
    public void actividadAceptarCitas(View v) {
        /*Intent pantallaPaciente = new Intent(getApplicationContext(), DetallePaciente.class);
        startActivity(pantallaPaciente);*/
        Toast.makeText(this, "Aun no hay pantalla de aceptar citas", Toast.LENGTH_SHORT).show();
    }
    public void actividadHorarioAtencion(View v) {
        Intent pantallaHorarioAtencion = new Intent(getApplicationContext(), DisponibilidadMedico.class);
        startActivity(pantallaHorarioAtencion);
    }
}
