package at.test.mouse;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Viewport viewport;
    private final ShapeRenderer debugRenderer;
    private OrthogonalTiledMapRenderer renderer;

    public GameScreen() {
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        viewport = new FitViewport(30f, 20f, camera);
        viewport.apply();

        TiledMap load = new TmxMapLoader().load("map.tmx");
        renderer = new OrthogonalTiledMapRenderer(load, 1f / 32f);


        camera.position.set(15, 10, 0);
        camera.update();
        renderer.setView(camera);

        debugRenderer = new ShapeRenderer();
        debugRenderer.setProjectionMatrix(camera.combined);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        renderer.render();
        batch.end();

        debugRenderer.begin(ShapeRenderer.ShapeType.Filled);
        Vector2 mouse = new Vector2(Gdx.input.getX(), Gdx.input.getY());


        Vector2 unprojected = viewport.unproject(mouse);

        System.out.println(unprojected);
        debugRenderer.circle(unprojected.x, unprojected.y, 0.2f, 100);
        debugRenderer.end();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
