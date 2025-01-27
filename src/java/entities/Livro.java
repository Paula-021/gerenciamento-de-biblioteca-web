/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author anapa
 */
public class Livro {
    
    private int id;
    private String titulo;
    private String autor;
    private Integer anoPubli;

    public Livro(int id, String titulo, String autor, Integer anoPubli) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPubli = anoPubli;
    }

    public Livro(String titulo, String autor, int anoPubli) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPubli = anoPubli;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPubli() {
        return anoPubli;
    }

    public void setAnoPubli(Integer anoPubli) {
        this.anoPubli = anoPubli;
    }

   
    
}
