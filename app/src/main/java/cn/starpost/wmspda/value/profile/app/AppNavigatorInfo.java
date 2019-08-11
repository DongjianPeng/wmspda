package cn.starpost.wmspda.value.profile.app;

/**
 * 顶部标题栏配置
 */
public class AppNavigatorInfo {
    private boolean showBackButton;
    private boolean showTitle;
    private String title;
    private boolean showSettingButton;

    public AppNavigatorInfo() {
    }

    public AppNavigatorInfo(boolean showBackButton, boolean showTitle, String title, boolean showSettingButton) {
        this.showBackButton = showBackButton;
        this.showTitle = showTitle;
        this.title = title;
        this.showSettingButton = showSettingButton;
    }

    public boolean isShowBackButton() {
        return showBackButton;
    }

    public void setShowBackButton(boolean showBackButton) {
        this.showBackButton = showBackButton;
    }

    public boolean isShowTitle() {
        return showTitle;
    }

    public void setShowTitle(boolean showTitle) {
        this.showTitle = showTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isShowSettingButton() {
        return showSettingButton;
    }

    public void setShowSettingButton(boolean showSettingButton) {
        this.showSettingButton = showSettingButton;
    }
}
