

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import views.IndexView;

public class AlumnosApplication extends Application {

	public static void main(String[] args) {
		new AlumnosApplication().start();
	}
	
	@Override
	protected Window<?> createMainWindow() {
		return new IndexView(this);
	}
}
