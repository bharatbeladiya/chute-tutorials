package com.chute.android.useravatar.app;

import com.chute.android.useravatar.R;
import com.chute.android.useravatar.util.PreferenceUtil;
import com.darko.imagedownloader.ImageLoader;

import android.app.Application;
import android.content.Context;
import android.util.TypedValue;

public class UserAvatarApp extends Application {

	@SuppressWarnings("unused")
	private static final String TAG = UserAvatarApp.class.getSimpleName();

	private static ImageLoader createImageLoader(Context context) {
		ImageLoader imageLoader = new ImageLoader(context,
				R.drawable.placeholder_image_small);
		imageLoader.setRequiredSize((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 75, context.getResources()
						.getDisplayMetrics()));
		return imageLoader;
	}

	private ImageLoader mImageLoader;

	@Override
	public void onCreate() {
		super.onCreate();
		mImageLoader = createImageLoader(this);
		PreferenceUtil.init(getApplicationContext());
	}

	@Override
	public Object getSystemService(String name) {
		if (ImageLoader.IMAGE_LOADER_SERVICE.equals(name)) {
			return mImageLoader;
		} else {
			return super.getSystemService(name);
		}
	}
}