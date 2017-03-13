package singh.saurabh.iscfresnostate.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import singh.saurabh.iscfresnostate.Constants.Konst;
import singh.saurabh.iscfresnostate.FeedModel;
import singh.saurabh.iscfresnostate.Helpers.Util;
import singh.saurabh.iscfresnostate.R;

/**
 * Created by saurabhsingh on 3/11/17.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    private Context context;
    private List<FeedModel.FeedItem> mFeedItems;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        ImageView itemImageView;
        TextView fromUsername;
        TextView createdAtTextView;
        TextView descriptionTextView;
        LinearLayout linkContainer;
        TextView linkNameTexView;
        TextView linkDescriptionTexView;
        TextView linkUrlTexView;

        public ViewHolder(View v) {
            super(v);
            itemImageView = (ImageView)v.findViewById(R.id.feed_item_imageView);
            fromUsername = (TextView)v.findViewById(R.id.feed_username_textView);
            createdAtTextView = (TextView)v.findViewById(R.id.feed_created_at_textView);
            descriptionTextView = (TextView)v.findViewById(R.id.feed_description_textView);
            linkContainer = (LinearLayout)v.findViewById(R.id.feed_link_container);
            linkNameTexView = (TextView)v.findViewById(R.id.feed_link_name_textView);
            linkDescriptionTexView = (TextView)v.findViewById(R.id.feed_link_description_textView);
            linkUrlTexView = (TextView)v.findViewById(R.id.feed_link_url_textView);
        }
    }

    public FeedAdapter(List<FeedModel.FeedItem> feedItems) {
        this.mFeedItems = feedItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        // create a new view
        View v = (View) LayoutInflater.from(context)
                .inflate(R.layout.feed_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FeedModel.FeedItem feedItem = mFeedItems.get(position);

        if (feedItem.getPictureUrl() == null || feedItem.getPictureUrl().isEmpty()) {
            holder.itemImageView.setVisibility(View.GONE);
        } else {
            holder.itemImageView.setVisibility(View.VISIBLE);
            Glide.with(context)
                    .load(feedItem.getPictureUrl())
                    .centerCrop()
                    .into(holder.itemImageView);
        }

        holder.fromUsername.setText(feedItem.getFromUser().getName());
        holder.createdAtTextView.setText(Util.formatTimeForEvent(feedItem.getCreatedTime()));
        if (feedItem.getMessage() == null || feedItem.getMessage().isEmpty()) {
            holder.descriptionTextView.setText(feedItem.getStory());
        } else {
            holder.descriptionTextView.setText(feedItem.getMessage());
        }
        if (feedItem.getType().equals("link")) {
            holder.linkContainer.setVisibility(View.VISIBLE);
            holder.linkNameTexView.setText(feedItem.getPostName());
            holder.linkDescriptionTexView.setText(feedItem.getDescription());
            String url = feedItem.getLink();
            url = url.replace("http://", "").toUpperCase();
            url = url.replace("/", "");
            holder.linkUrlTexView.setText(url);
        } else {
            holder.linkContainer.setVisibility(View.GONE);
        }


        float textSize = 15;
        /*
        enum { link, status, photo, video, offer }
        */
        switch (feedItem.getType()) {
            case "event":
            case "link":
            case "photo":
            case "video":
            case "offer":
                textSize = 15;
                break;
            case "status":
                if (holder.descriptionTextView.getText().length() > Konst.getMaxStatusLength()) {
                    textSize = 15;
                } else {
                    textSize += 4;
                }
                break;
        }
        holder.descriptionTextView.setTextSize(textSize);
    }

    @Override
    public int getItemCount() {
        return mFeedItems.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
