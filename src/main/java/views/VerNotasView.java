package views;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.ErrorsPanel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import model.Alumno;
import model.Asignacion;
import model.NoExisteLegajoIngresadoException;
import viewModels.VerNotasViewModel;

@SuppressWarnings("serial")
public class VerNotasView extends Dialog<VerNotasViewModel> {
	
	Panel form;

	public VerNotasView(WindowOwner owner, Alumno alumno) {
		super(owner, new VerNotasViewModel(alumno));
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Ver mis notas");
		form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(3));
		
		new Label(form).setText("Bienvenido:");
		new Label(form).bindValueToProperty("nombreYApellido");//TODO hacer que se actualice si cambias los datos del alumno
		Table<Asignacion> tableAsignaciones = new Table<>(mainPanel, Asignacion.class);
		tableAsignaciones.bindItemsToProperty("asignaciones");
		
		Column<Asignacion> columnaTarea = new Column<Asignacion>(tableAsignaciones);
		columnaTarea.setTitle("Tarea").bindContentsToProperty("nombreTarea");
		
		Column<Asignacion> columnaNotas = new Column<Asignacion>(tableAsignaciones);
		columnaNotas.setTitle("Notas").bindContentsToProperty("valorCalificacionActual");
		
		Column<Asignacion> columnaAprobado = new Column<Asignacion>(tableAsignaciones);
		columnaAprobado.setTitle("Aprobado").bindContentsToProperty("estaONoAprobada");
		
		new Button(mainPanel).setCaption("Actualizar mis datos").onClick(this::editarPerfil);
		
		tableAsignaciones.setHeight(300);
		tableAsignaciones.setWidth(600);
		
	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(this::close);
		// TODO cerrar todo -> se puede?
	}
	
	public void editarPerfil() {		
		Window<?> window = new EditarPerfilView(this, this.obtenerAlumno());
		window.open();
	}
	
	protected Alumno obtenerAlumno() {
		return this.getModelObject().getAlumno();
	}
}
