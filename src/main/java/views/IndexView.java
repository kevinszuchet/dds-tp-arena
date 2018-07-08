package views;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.ErrorsPanel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import model.Alumno;
import model.NoExisteLegajoIngresadoException;
import viewModels.IndexViewModel;

@SuppressWarnings("serial")
public class IndexView extends SimpleWindow<IndexViewModel> {
	
	Panel form;
	Alumno alumno;

	public IndexView(WindowOwner parent) {
		super(parent, new IndexViewModel());
	}

	@Override
	protected void addActions(Panel panelActions) {
	}

	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Sistema de alumnos");
		form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(3));
		
		new Label(form).setText("Ingrese su legajo");
		new TextBox(mainPanel).bindValueToProperty("legajo");
		
		new Button(mainPanel).setCaption("Ver mis notas").onClick(this::verNotas);
		new Button(mainPanel).setCaption("Actualizar mis datos").onClick(this::editarPerfil);
	}

	public void verNotas() {
		obtenerAlumno();
		Dialog<?> dialog = new VerNotasView(this, alumno);
		dialog.open();
		dialog.onAccept(() -> {});
	}

	public void editarPerfil() {
		obtenerAlumno();
		Window<?> window = new EditarPerfilView(this, alumno);
		window.open();
	}
	
	protected void obtenerAlumno() {
		// TODO habria que mejorar el tema de la variable alumno y que no muestra los errores
		try {
			alumno = this.getModelObject().getAlumnoXlegajo();
		} catch(NoExisteLegajoIngresadoException e) {
			new ErrorsPanel(form, "El legajo ingresado no existe", 1);
		}
	}
}