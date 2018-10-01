package views;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.ObservableUtils;

import model.Alumno;
import model.Asignacion;
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
		form.setLayout(new ColumnLayout(2));

		Panel datosAlumnoPanel = new Panel(form).setLayout(new VerticalLayout());
		
		Panel panelNombre = new Panel(datosAlumnoPanel).setLayout(new HorizontalLayout());
		new Label(panelNombre).setText("Bienvenido: ");
		new Label(panelNombre).bindValueToProperty("nombreYApellido");
		
		Table<Asignacion> tableAsignaciones = new Table<>(mainPanel, Asignacion.class);
		tableAsignaciones.bindItemsToProperty("asignaciones");
		
		Column<Asignacion> columnaTarea = new Column<Asignacion>(tableAsignaciones);
		columnaTarea.setTitle("Tarea").bindContentsToProperty("nombreTarea");
		
		Column<Asignacion> columnaNotas = new Column<Asignacion>(tableAsignaciones);
		columnaNotas.setTitle("Notas").bindContentsToProperty("valorCalificacionActual");
		
		Column<Asignacion> columnaAprobado = new Column<Asignacion>(tableAsignaciones);
		columnaAprobado.setTitle("Aprobado").bindContentsToProperty("estaONoAprobada");		
		
		tableAsignaciones.setHeight(300);
		tableAsignaciones.setWidth(600);
		
		new Button(mainPanel).setCaption("Actualizar mis datos").onClick(this::editarPerfil);
	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(this::close);
		// TODO cerrar todo -> se puede?
	}
	
	public void editarPerfil() {		
		Dialog<?> dialog = new EditarPerfilView(this, this.obtenerAlumno());
		dialog.onAccept(() -> ObservableUtils.firePropertyChanged(this.getModelObject(), "nombreYApellido"));
		dialog.open();
	}
	
	protected Alumno obtenerAlumno() {
		return this.getModelObject().getAlumno();
	}
}
