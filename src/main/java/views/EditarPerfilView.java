package views;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import model.Alumno;
import viewModels.EditarPerfilViewModel;
import viewModels.VerNotasViewModel;

@SuppressWarnings("serial")
public class EditarPerfilView extends Dialog<EditarPerfilViewModel> {
	
	Panel form;

	public EditarPerfilView(WindowOwner owner, Alumno alumno) {
		super(owner, new EditarPerfilViewModel(alumno));
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Ver mis notas");
		form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		
		int preferedSize = 100;
		new Label(form).bindValueToProperty("nombreYApellido");
		new Label(form).setText("Nombre y apellido");
		new TextBox(form).setWidth(preferedSize).bindValueToProperty("nombreYApellido");
		
		new Label(form).setText("Legajo");
		new NumericField(form).setWidth(preferedSize).bindValueToProperty("legajo");
		
		new Label(form).setText("Usuario de github");
		new TextBox(form).setWidth(preferedSize).bindValueToProperty("usuarioGithub");
		
		new Button(form).setCaption("Guardar").onClick(this::guardar).setAsDefault();
		new Button(form).setCaption("Volver").onClick(this::close);
	}

	@Override
	protected void addActions(Panel actions) {
	}
	
	public void guardar() {
		this.getModelObject().modificarPerfil();
		this.close();
	}
	
	protected Alumno obtenerAlumno() {
		return this.getModelObject().getAlumno();
	}
}
