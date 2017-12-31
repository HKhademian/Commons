package ir.hossainco.commons.android.stetho;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.facebook.stetho.Stetho;

public class StethoInitProvider extends ContentProvider {

	@Override
	public boolean onCreate() {
		//noinspection ConstantConditions
		Stetho.initializeWithDefaults(getContext());
		return true;
	}

	@Override
	public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getType(@NonNull Uri uri) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Uri insert(@NonNull Uri uri, ContentValues values) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Cursor query(@NonNull Uri uri, String[] projection, String selection,
	                    String[] selectionArgs, String sortOrder) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int update(@NonNull Uri uri, ContentValues values, String selection,
	                  String[] selectionArgs) {
		throw new UnsupportedOperationException();
	}
}
