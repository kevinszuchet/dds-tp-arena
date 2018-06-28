package views;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import viewModels.IndexViewModel;

public class IndexView extends SimpleWindow<IndexViewModel> {

	public IndexView(WindowOwner parent) {
		super(parent, new IndexViewModel());
	}

	@Override
	protected void addActions(Panel panelActions) {
		panelActions.setLayout(new VerticalLayout());
		new Button(panelActions).setCaption("Ver mis notas").onClick(this::verNotas);
		new Button(panelActions).setCaption("Actualizar mis datos").onClick(this::editarPerfil);
	}

	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Sistema de alumnos");
	}

	public void verNotas() {
		Window<?> window = new VerNotasView(this);
		window.open();
	}

	public void editarPerfil() {
		Window<?> window = new EditarPerfilView(this);
		window.open();
	}
}