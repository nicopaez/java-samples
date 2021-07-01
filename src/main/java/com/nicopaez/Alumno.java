package com.nicopaez;

public class Alumno {
    static final String MAIL_INDEFINIDO = "no_mail";
    private final String mail;
    private final int edad;
    private final String apellido;
    private final String nombre;

    public Alumno(String nombre, String apellido, int edad){
        this(nombre, apellido, edad, MAIL_INDEFINIDO);
    }

    public Alumno(String nombre, String apellido, int edad, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.mail = mail;
    }

    public boolean esMenorA(Integer edadMinima) {
        return edadMinima > this.edad;
    }

    public boolean tieneMail() {
        return !MAIL_INDEFINIDO.equals(this.mail);
    }
}
