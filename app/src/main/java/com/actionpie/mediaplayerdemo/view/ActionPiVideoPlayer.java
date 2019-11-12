package com.actionpie.mediaplayerdemo.view;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.actionpie.mediaplayerdemo.R;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoViewBridge;

/**
 * 自定义视频播放器
 */
public class ActionPiVideoPlayer extends GSYVideoPlayer {
    private Dialog mProgressDialog;

    public ActionPiVideoPlayer(@NonNull Context context) {
        this(context, null);
    }

    public ActionPiVideoPlayer(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ActionPiVideoPlayer(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init(Context context) {
        super.init(context);
    }

    /**
     * 布局文件id
     * @return
     */
    @Override
    public int getLayoutId() {
        return R.layout.view_video_player;
    }

    /**
     * 开始播放逻辑，
     */
    @Override
    public void startPlayLogic() {
        prepareVideo();
        startDismissControlViewTimer();
    }

    /**
     * 判断网络状态，如非wifi网络提示用户是否继续播放
     */
    @Override
    protected void showWifiDialog() {
        startPlayLogic();
    }

    @Override
    protected void showProgressDialog(float deltaX, String seekTime, int seekTimePosition, String totalTime, int totalTimeDuration) {
        if (mProgressDialog == null) {
            View localView = LayoutInflater.from(getActivityContext()).inflate(getProgressDialogLayoutId(), null);
            if (localView.findViewById(getProgressDialogProgressId()) instanceof ProgressBar) {
                /*mDialogProgressBar = ((ProgressBar) localView.findViewById(getProgressDialogProgressId()));
                if (mDialogProgressBarDrawable != null) {
                    mDialogProgressBar.setProgressDrawable(mDialogProgressBarDrawable);
                }*/
            }
            /*if (localView.findViewById(getProgressDialogCurrentDurationTextId()) instanceof TextView) {
                mDialogSeekTime = ((TextView) localView.findViewById(getProgressDialogCurrentDurationTextId()));
            }
            if (localView.findViewById(getProgressDialogAllDurationTextId()) instanceof TextView) {
                mDialogTotalTime = ((TextView) localView.findViewById(getProgressDialogAllDurationTextId()));
            }
            if (localView.findViewById(getProgressDialogImageId()) instanceof ImageView) {
                mDialogIcon = ((ImageView) localView.findViewById(getProgressDialogImageId()));
            }
            mProgressDialog = new Dialog(getActivityContext(), com.shuyu.gsyvideoplayer.R.style.video_style_dialog_progress);
            mProgressDialog.setContentView(localView);
            mProgressDialog.getWindow().addFlags(Window.FEATURE_ACTION_BAR);
            mProgressDialog.getWindow().addFlags(32);
            mProgressDialog.getWindow().addFlags(16);
            mProgressDialog.getWindow().setLayout(getWidth(), getHeight());
            if (mDialogProgressNormalColor != -11 && mDialogTotalTime != null) {
                mDialogTotalTime.setTextColor(mDialogProgressNormalColor);
            }
            if (mDialogProgressHighLightColor != -11 && mDialogSeekTime != null) {
                mDialogSeekTime.setTextColor(mDialogProgressHighLightColor);
            }
            WindowManager.LayoutParams localLayoutParams = mProgressDialog.getWindow().getAttributes();
            localLayoutParams.gravity = Gravity.TOP;
            localLayoutParams.width = getWidth();
            localLayoutParams.height = getHeight();
            int location[] = new int[2];
            getLocationOnScreen(location);
            localLayoutParams.x = location[0];
            localLayoutParams.y = location[1];
            mProgressDialog.getWindow().setAttributes(localLayoutParams);*/
        }
        /*if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
        if (mDialogSeekTime != null) {
            mDialogSeekTime.setText(seekTime);
        }
        if (mDialogTotalTime != null) {
            mDialogTotalTime.setText(" / " + totalTime);
        }
        if (totalTimeDuration > 0)
            if (mDialogProgressBar != null) {
                mDialogProgressBar.setProgress(seekTimePosition * 100 / totalTimeDuration);
            }
        if (deltaX > 0) {
            if (mDialogIcon != null) {
                mDialogIcon.setBackgroundResource(com.shuyu.gsyvideoplayer.R.drawable.video_forward_icon);
            }
        } else {
            if (mDialogIcon != null) {
                mDialogIcon.setBackgroundResource(com.shuyu.gsyvideoplayer.R.drawable.video_backward_icon);
            }
        }*/
    }

    @Override
    protected void dismissProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    protected int getProgressDialogLayoutId() {
        return R.layout.video_progress_dialog;
    }

    /**
     * 触摸进度dialog的进度条id
     * 继承后重写可返回自定义，如果没有可返回空
     * 有自定义的实现逻辑可重载showProgressDialog方法
     */
    protected int getProgressDialogProgressId() {
        return R.id.duration_progressbar;
    }

    /**
     * 触摸音量dialog，如需要自定义继承重写即可，记得重写dismissVolumeDialog
     * @param deltaY
     * @param volumePercent
     */
    @Override
    protected void showVolumeDialog(float deltaY, int volumePercent) {

    }

    @Override
    protected void dismissVolumeDialog() {

    }

    /**
     * 触摸亮度dialog，如需要自定义继承重写即可，记得重写dismissBrightnessDialog
     * @param percent
     */
    @Override
    protected void showBrightnessDialog(float percent) {

    }

    @Override
    protected void dismissBrightnessDialog() {

    }

    /**
     * 点击触摸显示和隐藏逻辑
     */
    @Override
    protected void onClickUiToggle() {

    }

    /**
     * 隐藏所有组件
     */
    @Override
    protected void hideAllWidget() {

    }

    /**
     * 修改UI为常规状态，默认显示
     */
    @Override
    protected void changeUiToNormal() {

    }

    @Override
    protected void changeUiToPreparingShow() {

    }

    @Override
    protected void changeUiToPlayingShow() {

    }

    @Override
    protected void changeUiToPauseShow() {

    }

    @Override
    protected void changeUiToError() {

    }

    @Override
    protected void changeUiToCompleteShow() {

    }

    @Override
    protected void changeUiToPlayingBufferingShow() {

    }

}
