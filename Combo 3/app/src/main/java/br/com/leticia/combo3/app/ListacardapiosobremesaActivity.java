package br.com.leticia.combo3.app;



public class ListacardapiosobremesaActivity
{
    private long id;
    private String titulo;
    private String descricao;

    public ListacardapiosobremesaActivity() {}

    public ListacardapiosobremesaActivity(long id, String titulo, String descricao)
    {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao)
    {
        this.titulo = descricao;
    }

    public long getId()
    {
        return this.id;
    }

    public String getTitulo()
    {
        return this.titulo;
    }

    public String getDescricao()
    {
        return this.descricao;
    }
}