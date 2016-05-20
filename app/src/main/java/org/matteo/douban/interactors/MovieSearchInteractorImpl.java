package org.matteo.douban.interactors;

import android.util.Log;

import org.matteo.douban.api.DoubanApi;
import org.matteo.douban.bean.ArrayResult;
import org.matteo.douban.bean.Subject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by matteo on 2016/5/19.
 */
public class MovieSearchInteractorImpl implements MovieSearchInteractor{

    private DoubanApi doubanApi;

    public MovieSearchInteractorImpl(DoubanApi doubanApi) {
        this.doubanApi = doubanApi;
    }

    @Override
    public void search(String q, final MovieSearchCallback callback) {
        doubanApi.searchByQ(q)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ArrayResult<Subject>>() {
                    @Override
                    public void call(ArrayResult<Subject> subjectArrayResult) {
                        callback.getSearchResult(subjectArrayResult.getSubjects());
                    }
                });
    }
}
