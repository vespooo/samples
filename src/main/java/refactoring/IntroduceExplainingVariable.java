package refactoring;

/**
 * replace difficult expression with meaningful variable
 */
public class IntroduceExplainingVariable {
    private String platform;
    private String browser;
    private int resize;

    void oldCode(){
        if ( (platform.toUpperCase().indexOf("MAC") > -1) &&
                (browser.toUpperCase().indexOf("IE") > -1) &&
                wasInitialized() && resize > 0 )
        {
            // do something
        }

    }

    void newCode(){
        boolean isMacOS = platform.toUpperCase().indexOf("MAC")> -1;
        boolean isIEBrowser = browser.toUpperCase().indexOf("IE") > -1;
        boolean wasResized = resize > 0;

        if ( isMacOS && isIEBrowser && wasInitialized() && wasResized)
        {
            // do something
        }

    }

    private boolean wasInitialized() {
        return true;
    }
}
