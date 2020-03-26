package controller;

import java.io.Serializable;

import javax.persistence.EntityManager;

import application.RepositoryException;
import application.Util;
import factory.JPAFactory;
import model.DefaultEntity;
import repository.Repository;

public abstract class Controller<T extends DefaultEntity<T>> implements Serializable {

	
	private static final long serialVersionUID = 5864180948764640904L;
	
	protected T entity;

	public abstract T getEntity();

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public Controller() {
		super();
	}

	public void salvar() {

		Repository<T> r = new Repository<T>();
		try {
			r.beginTransaction();
			r.salvar(getEntity());
			r.commitTransaction();
		} catch (RepositoryException e) {
			e.printStackTrace();
			r.rollBackTransaction();
			Util.addMessageError("Erro ao salvar");
			return;
		}
		limpar();
		Util.addMessageInfo("Cadastro realizado com sucesso.");

	}

	public void excluir() {

		Repository<T> r = new Repository<T>();
		try {
			r.beginTransaction();
			r.excluir(getEntity());
			r.commitTransaction();
		} catch (RepositoryException e) {
			e.printStackTrace();
			r.rollBackTransaction();
			Util.addMessageError("Erro ao excluir");
			return;
		}
		limpar();
		Util.addMessageInfo("Exclus�o realizada com sucesso.");
	}

	public void editar(int id) {
		EntityManager em = JPAFactory.getEntityManager();
		setEntity((T) em.find(getEntity().getClass(), id));
	}

	public void limpar() {
		entity = null;
	}

}