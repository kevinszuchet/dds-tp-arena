package views;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import viewModels.IndexViewModel;

@SuppressWarnings("serial")
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
		Dialog<?> dialog = new VerNotasView(this);
		dialog.open();
		dialog.onAccept(() -> {});
	}

	public void editarPerfil() {
		Window<?> window = new EditarPerfilView(this);
		window.open();
	}
}