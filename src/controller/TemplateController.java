package controller;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import model.Usuario;

@Named
@ViewScoped
public class TemplateController implements Serializable {
	//serializable
	private static final long serialVersionUID = 206276099339678780L;
	private Usuario usuarioLogado;

	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null) {
			// buscando o usuario da sessao
			usuarioLogado = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
			if (usuarioLogado == null)
				usuarioLogado = new Usuario();
		}
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String encerrarSessao() {
		Session.getInstance().invalidateSession();
		return "login.xhtml?faces-redirect=true";
	}
}
