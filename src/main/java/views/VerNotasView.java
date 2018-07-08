package views;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

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
		form.setLayout(new ColumnLayout(3));
		
		Table<Asignacion> tableAsignaciones = new Table<>(mainPanel, Asignacion.class);
		Column<Asignacion> columnaTarea = new Column<Asignacion>(tableAsignaciones);
		columnaTarea.setTitle("Tarea").bindContentsToProperty("asignaciones.getTarea()");
		
		Column<Asignacion> columnaNotas = new Column<Asignacion>(tableAsignaciones);
		columnaNotas.setTitle("Notas").bindContentsToProperty("asignaciones.calificaciones");
		
		tableAsignaciones.setHeight(300);
		tableAsignaciones.setWidth(600);
	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(this::close);
		// TODO cerrar todo -> se puede?
	}
}
