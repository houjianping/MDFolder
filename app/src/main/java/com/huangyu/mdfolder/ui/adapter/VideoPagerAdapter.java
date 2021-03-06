package com.huangyu.mdfolder.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.easyvideoplayer.EasyVideoCallback;
import com.afollestad.easyvideoplayer.EasyVideoPlayer;
import com.huangyu.mdfolder.R;
import com.huangyu.mdfolder.bean.FileItem;

import java.io.File;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by huangyu on 2017-6-20.
 */
public class VideoPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<FileItem> mVideoList;
    private EasyVideoCallback mEasyVideoCallback;

    public VideoPagerAdapter(Context context, List<FileItem> videoList, EasyVideoCallback easyVideoCallback) {
        this.mContext = context;
        this.mVideoList = videoList;
        this.mEasyVideoCallback = easyVideoCallback;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mVideoList == null ? 0 : mVideoList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, final int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_video_pager, viewGroup, false);
        EasyVideoPlayer easyVideoPlayer = ButterKnife.findById(view, R.id.video_player);
        easyVideoPlayer.setSource(Uri.fromFile(new File(mVideoList.get(position).getPath())));
        easyVideoPlayer.setCallback(mEasyVideoCallback);
        view.setTag("video" + position);
        viewGroup.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
