package views;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import model.Alumno;
import viewModels.EditarPerfilViewModel;

@SuppressWarnings("serial")
public class EditarPerfilView extends Dialog<EditarPerfilViewModel> {
	
	Panel form;

	public EditarPerfilView(WindowOwner owner, Alumno alumno) {
		super(owner, new EditarPerfilViewModel(alumno));
		this.setTitle("Ver mis notas");
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		
		int preferedSize = 100;
		
		new Label(form).setText("Nombre y apeliido");
		new TextBox(mainPanel).setWidth(preferedSize).bindValueToProperty("nombreYApellido");
		
		new Label(form).setText("Legajo");
		new NumericField(mainPanel).setWidth(preferedSize).bindValueToProperty("legajo");
		
		new Label(form).setText("Usuario de github");
		new TextBox(mainPanel).setWidth(preferedSize).bindValueToProperty("usuarioGithub");
		
		new Button(mainPanel).setCaption("Guardar").onClick(this::guardar).setAsDefault();
		new Button(mainPanel).setCaption("Volver").onClick(this::close);
	}

	@Override
	protected void addActions(Panel actions) {
	}
	
	public void guardar() {
		// TODO
	}
}
