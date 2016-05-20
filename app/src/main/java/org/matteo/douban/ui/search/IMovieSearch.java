package org.matteo.douban.ui.search;

import org.matteo.douban.bean.Subject;

import java.util.List;

/**
 * Created by matteo on 2016/5/19.
 */
public interface IMovieSearch {

    public void onSearchResult(List<Subject> subjects);
}
