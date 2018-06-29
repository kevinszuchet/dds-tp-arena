package views;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import viewModels.EditarPerfilViewModel;

@SuppressWarnings("serial")
public class EditarPerfilView extends Dialog<EditarPerfilViewModel> {
	
	Panel form;

	public EditarPerfilView(WindowOwner owner) {
		super(owner, new EditarPerfilViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Ver mis notas");
		form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Nombre y apeliido");
		new TextBox(mainPanel).bindValueToProperty("nombreYApellido");
		
		new Label(form).setText("Legajo");
		new NumericField(mainPanel).bindValueToProperty("legajo");
		
		new Label(form).setText("Usuario de github");
		new TextBox(mainPanel).bindValueToProperty("usuarioGithub");
	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Guardar").onClick(this::guardar).setAsDefault();
		new Button(actions).setCaption("Volver").onClick(this::close);
		// TODO cerrar todo -> se puede?
	}
	
	public void guardar() {
		// TODO
	}
}
