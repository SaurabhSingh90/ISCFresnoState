// Generated code from Butter Knife. Do not modify!
package singh.saurabh.iscfresnostate.view;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PostDescription$$ViewInjector<T extends singh.saurabh.iscfresnostate.view.PostDescription> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361920, "field 'mTitle'");
    target.mTitle = finder.castView(view, 2131361920, "field 'mTitle'");
    view = finder.findRequiredView(source, 2131361921, "field 'mFirstName'");
    target.mFirstName = finder.castView(view, 2131361921, "field 'mFirstName'");
    view = finder.findRequiredView(source, 2131361922, "field 'mDate'");
    target.mDate = finder.castView(view, 2131361922, "field 'mDate'");
    view = finder.findRequiredView(source, 2131361923, "field 'mTag'");
    target.mTag = finder.castView(view, 2131361923, "field 'mTag'");
    view = finder.findRequiredView(source, 2131361924, "field 'mListView'");
    target.mListView = finder.castView(view, 2131361924, "field 'mListView'");
  }

  @Override public void reset(T target) {
    target.mTitle = null;
    target.mFirstName = null;
    target.mDate = null;
    target.mTag = null;
    target.mListView = null;
  }
}