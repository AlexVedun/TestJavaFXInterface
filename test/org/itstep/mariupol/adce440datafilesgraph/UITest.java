package org.itstep.mariupol.adce440datafilesgraph;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.itstep.mariupol.adce440datafilesgraph.MainApp;
import org.itstep.mariupol.adce440datafilesgraph.view.RootLayoutController;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import static org.loadui.testfx.GuiTest.find;
import org.loadui.testfx.utils.FXTestUtils;
/**
 *
 * @author yurii
 */
public class UITest {
    private static GuiTest mMainController;
    private static Window mRootLayoutFileChooserWindow;
    private static RootLayoutController mRootLayoutController;

    @BeforeClass
    public static void setUpClass() {
        
        MainApp.onLoad(r -> {
            mMainController = new GuiTest() {
                @Override
                protected Parent getRootNode() {
                    return r;
                }
            };
            return null;
        });
        
        MainApp.onRootLayoutLoad(c -> {
            mRootLayoutController = c;
            return null;
        });

        FXTestUtils.launchApp(MainApp.class);
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testSeriesShow() throws InterruptedException, IOException {
    
        for (Window w : GuiTest.getWindows()) {
            System.out.println(w.toString());
        }
        //mController.click("#mOpenMenuItem");
        /*Assert.assertNotNull(find("#mOpenMenu"));
        mMainController.click("#mOpenMenu");
        Thread.sleep(3000);
        
        
        
        Assert.assertNotNull(find("#mOpenMenuItem"));
        mMainController.click("#mOpenMenuItem");
        Thread.sleep(3000);*/
        
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                try {
                    mRootLayoutController.openFile(new File("C:\\Users\\student\\tyaa\\data\\10f.dat"));
                    mRootLayoutController.openFile(new File("C:\\Users\\student\\tyaa\\data\\16 02 2013 9-10.dat"));
                    Thread.sleep(3000);
                    
                    Thread.sleep(3000);
                } catch (IOException ex) {
                    Logger.getLogger(UITest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(UITest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        // ...
        });
        Thread.sleep(3000);
        //mChannelLineChart
        Assert.assertNotNull(find("#mChannelLineChart"));
        Assert.assertNotNull(find("file_1"));
        Assert.assertNotNull(find("file_2"));
        mMainController.click("file_1");
        GuiTest.captureScreenshot();
        Thread.sleep(3000);
        
        //Stage dialogStage = GuiTest.findStageByTitle("Open");
        //Stage dialogStage = GuiTest.findStageByTitle("Открыть");
        //Window dialogWindow = dialogStage.getOwner();
        //GuiTest.targetWindow(dialogWindow);        
        //System.out.println(dialogWindow);
        
        //Assert.assertNotNull(find("Открыть"));
        //mController.target(mController.);
        //mRootLayoutController.click("Открыть");
        //Thread.sleep(3000);
        //Assert.assertNotNull(find("#chb1"));
        //mMainController.click("#chb1");
    }
}
