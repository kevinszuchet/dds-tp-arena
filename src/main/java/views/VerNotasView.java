package views;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import model.Alumno;
import viewModels.VerNotasViewModel;

public class VerNotasView extends Dialog<VerNotasViewModel> {

	public VerNotasView(WindowOwner owner) {
		super(owner, new VerNotasViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Prendas");
		Selector<Alumno> selectorPrenda = new Selector<Alumno>(form).allowNull(true);
		selectorPrenda.bindItemsToProperty("alumnos");
		selectorPrenda.bindValueToProperty("alumnoSeleccionado");
	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick(this::accept).setAsDefault();
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}

	@Override
	protected void executeTask() {
		System.out.println("Me aceptaron, yuppiiii!!!");
		super.executeTask();
	}
}
