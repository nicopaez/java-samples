package com.nicopaez;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CursoTest {

    @Test
    public void SeCreaConNombreYCupo(){
        String nombre = "Matematica 1";
        Integer cupo = 30;
        Curso curso = new Curso(nombre, cupo);
        assertThat(curso.getCupoMaximo(), equalTo(cupo));
        assertThat(curso.getNombre(), equalTo(nombre));
    }

    @Test
    public void edadMinimaEsCeroPorDefecto(){
        String nombre = "Matematica 1";
        Integer cupo = 30;
        Curso curso = new Curso(nombre, cupo);
        assertThat(curso.getEdadMinima(), equalTo(0));
    }

    @Test
    public void cuandoInscribeAlumnosDecrementaElCupoDisponible(){
        String nombre = "Matematica 1";
        Integer cupo = 30;
        Curso curso = new Curso(nombre, cupo);
        Alumno alumnoJuan = new Alumno("Juan", "Perez", 25, "juanp@unmail.com");

        curso.inscribir(alumnoJuan);

        assertThat(curso.getCupoDisponible(), equalTo(cupo - 1));
    }

    @Test(expected = AlumnoInadminisbleException.class)
    public void noPermiteInscribirAlumnosMenores(){
        String nombre = "Matematica 1";
        Integer cupo = 30;
        Curso curso = new Curso(nombre, cupo);
        curso.establecerEdadMinimaAdmitida(18);
        Alumno alumnoJuan = new Alumno("Juan", "Perez", 12, "juanp@unmail.com");

        curso.inscribir(alumnoJuan);
    }

    @Test(expected = AlumnoInadminisbleException.class)
    public void noPermiteInscribirAlumnosSinMail(){
        String nombre = "Matematica 1";
        Integer cupo = 30;
        Curso curso = new Curso(nombre, cupo);
        curso.establecerEdadMinimaAdmitida(18);
        Alumno alumnoJuan = new Alumno("Juan", "Perez", 22);

        curso.inscribir(alumnoJuan);
    }
}
