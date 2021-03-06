package model;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

public class ListaMedicamentos implements Serializable {
    private Instant fechaActualizacion;
    private List<Medicamento> medicamentos;

    public ListaMedicamentos(Instant fechaActualizacion, List<Medicamento> medicamentos) {
        this.fechaActualizacion = fechaActualizacion;
        this.medicamentos = medicamentos;
    }

    public Instant getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Instant fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String toStringJSON() {
        StringBuilder s = new StringBuilder(fechaActualizacion.toString());
        for(Medicamento med: medicamentos) {
            s.append("\\").append(med.toStringJSON());
        }
        return s.toString();
    }
}
