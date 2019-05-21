package me.mapmaker;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import me.mapmaker.interactive.Interactive;

public class GUI extends Application {
	
	private static final int WIDTH = 720, HEIGHT = WIDTH/4*3;
	
	private final MenuItem[] menuItems = new MenuItem[9];
	private final Menu fileMenu = new Menu("File");
	private final Menu settings = new Menu("Settings");
	private final Menu help = new Menu("Help");
	private final MenuBar menuBar = new MenuBar(fileMenu, settings, help);
	
	private final Interactive horizontalInteractives = new Interactive();
	private final ToolBar horizontalToolBar = new ToolBar();
	
	private final Interactive verticalInteractives = new Interactive();
	private final ToolBar verticalToolBar = new ToolBar();
	
	private final Group root = new Group(menuBar, horizontalToolBar, verticalToolBar);
	private final Scene scene = new Scene(root, WIDTH, HEIGHT, Color.WHITE);

	@Override
	public void start(Stage primaryStage) throws Exception {
		init();
		
		horizontalToolBar.setLayoutY(25);
		horizontalToolBar.setPrefHeight(25);
		horizontalToolBar.prefWidthProperty().bind(primaryStage.widthProperty());
		
		verticalToolBar.setLayoutY(50);
		verticalToolBar.setPrefWidth(150);
		verticalToolBar.setOrientation(Orientation.VERTICAL);
		verticalToolBar.prefHeightProperty().bind(primaryStage.heightProperty());
		verticalToolBar.setBorder(new Border(new BorderStroke(null, Color.BLANCHEDALMOND, null, null, null, BorderStrokeStyle.SOLID, null, null, CornerRadii.EMPTY, new BorderWidths(2.5), Insets.EMPTY)));
		
		
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		
		fileMenu.getItems().addAll(menuItems);
		
		for(Node node: verticalInteractives.getNodes())
			if(node != null)
			verticalToolBar.getItems().add(node);
		
		for(Node node: horizontalInteractives.getNodes())
			if(node != null)
			horizontalToolBar.getItems().add(node);
		
		primaryStage.setTitle("MapMaker");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void init() {
		menuItems[0] = new MenuItem("New file");
		menuItems[1] = new SeparatorMenuItem();
		menuItems[2] = new MenuItem("Save file");
		menuItems[3] = new MenuItem("Load file");
		menuItems[4] = new SeparatorMenuItem();
		menuItems[5] = new MenuItem("Export file");
		menuItems[6] = new MenuItem("Import file");
		menuItems[7] = new SeparatorMenuItem();
		menuItems[8] = new MenuItem("Exit");
	}
}
