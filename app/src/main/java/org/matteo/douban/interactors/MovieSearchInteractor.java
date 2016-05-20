package org.matteo.douban.interactors;

import org.matteo.douban.bean.Subject;

import java.util.List;

/**
 * Created by matteo on 2016/5/19.
 */
public interface MovieSearchInteractor {

    void search(String q, MovieSearchCallback callback);

    interface MovieSearchCallback{
        void getSearchResult(List<Subject> subjects);
    }
}
