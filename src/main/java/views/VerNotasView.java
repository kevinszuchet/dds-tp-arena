package views;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.ErrorsPanel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import model.Asignacion;
import model.NoExisteLegajoIngresadoException;
import viewModels.VerNotasViewModel;

@SuppressWarnings("serial")
public class VerNotasView extends SimpleWindow<VerNotasViewModel> {
	
	Panel form;

	public VerNotasView(WindowOwner owner) {
		super(owner, new VerNotasViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Ver mis notas");
		form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(3));
		
		new Label(form).setText("Legajo");
		new NumericField(mainPanel).bindValueToProperty("legajo");
		new Button(mainPanel).setCaption("Ingresar").onClick(this::cargarAsignaciones);
		
		Table<Asignacion> tableAsignaciones = new Table<>(mainPanel, Asignacion.class);
		Column<Asignacion> columnaTarea = new Column<Asignacion>(tableAsignaciones);
		columnaTarea.setTitle("Tarea").bindContentsToProperty("asignacion.tarea");
		
		Column<Asignacion> columnaNotas = new Column<Asignacion>(tableAsignaciones);
		columnaNotas.setTitle("Notas").bindContentsToProperty("asignacion.calificaciones");
		
		tableAsignaciones.setHeight(300);
		tableAsignaciones.setWidth(600);
	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Volver").onClick(this::close);
		// TODO cerrar todo -> se puede?
	}
	
	protected void cargarAsignaciones() {
		try {			
			this.getModelObject().cargarAsignaciones();
		} catch(NoExisteLegajoIngresadoException e) {
			new ErrorsPanel(form, "El legajo ingresado no existe", 1);
		}		
	}
}
