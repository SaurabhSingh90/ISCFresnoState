// Generated code from Butter Knife. Do not modify!
package singh.saurabh.iscfresnostate.view;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AddNewJobPost$$ViewInjector<T extends singh.saurabh.iscfresnostate.view.AddNewJobPost> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361877, "field 'mTitleEditText'");
    target.mTitleEditText = finder.castView(view, 2131361877, "field 'mTitleEditText'");
    view = finder.findRequiredView(source, 2131361878, "field 'mLocationEditText'");
    target.mLocationEditText = finder.castView(view, 2131361878, "field 'mLocationEditText'");
    view = finder.findRequiredView(source, 2131361879, "field 'mPostContentEditText'");
    target.mPostContentEditText = finder.castView(view, 2131361879, "field 'mPostContentEditText'");
    view = finder.findRequiredView(source, 2131361880, "field 'mPostTagsEditText'");
    target.mPostTagsEditText = finder.castView(view, 2131361880, "field 'mPostTagsEditText'");
    view = finder.findRequiredView(source, 2131361882, "field 'mSubmitPostButton'");
    target.mSubmitPostButton = finder.castView(view, 2131361882, "field 'mSubmitPostButton'");
  }

  @Override public void reset(T target) {
    target.mTitleEditText = null;
    target.mLocationEditText = null;
    target.mPostContentEditText = null;
    target.mPostTagsEditText = null;
    target.mSubmitPostButton = null;
  }
}