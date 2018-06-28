package views;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import viewModels.AlgoViewModel;

public class IndexView extends SimpleWindow<AlgoViewModel> {

	public IndexView(WindowOwner parent) {
		super(parent, new AlgoViewModel());
	}

	@Override
	protected void addActions(Panel panelActions) {
		new Button(panelActions).setCaption("Ver mis notas").onClick(this::verNotas);
		new Button(panelActions).setCaption("Actualizar mis datos").onClick(this::editarPerfil);
	}

	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Sistema de alumnos");
		
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
	}

	public void verNotas() {
		Window<?> window = new VerNotasView(this);
		window.open();
	}

	public void editarPerfil() {
		Window<?> window = new VerNotasView(this);
		window.open();
	}
}