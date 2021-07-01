package com.nicopaez;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private final String nombre;
    private final Integer cupoMaximo;
    private List<Alumno> alumnos;
    private Integer edadMinima;

    public Curso(String nombre, Integer cupoMaximo) {
        this.nombre = nombre;
        this.cupoMaximo = cupoMaximo;
        this.edadMinima = 0;
        this.alumnos = new ArrayList<Alumno>();
    }

    public Integer getCupoMaximo() {
        return this.cupoMaximo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Integer getEdadMinima() {
        return this.edadMinima;
    }

    public void inscribir(Alumno alumno) {
        if (alumno.esMenorA(this.getEdadMinima())){
            throw new AlumnoInadminisbleException();
        }

        if (!alumno.tieneMail()){
            throw new AlumnoInadminisbleException();
        }

        this.alumnos.add(alumno);
    }

    public Integer getCupoDisponible() {
        return this.cupoMaximo - this.alumnos.size();
    }

    public void establecerEdadMinimaAdmitida(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }
}
