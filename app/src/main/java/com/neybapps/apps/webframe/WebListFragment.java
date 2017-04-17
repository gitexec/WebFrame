package com.neybapps.apps.webframe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebListFragment extends Fragment {
    public String urlName;
    WebView mWebView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            urlName = getArguments().getString("urlName");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

          View view = inflater.inflate(R.layout.fragment_web_list, container, false);
          mWebView = (WebView) view.findViewById(R.id.webview);
          mWebView.getSettings().setJavaScriptEnabled(true);

          WebSettings webSettings = mWebView.getSettings();

          webSettings.setJavaScriptEnabled(true);

          webSettings.setBuiltInZoomControls(true);

          mWebView.requestFocusFromTouch();

          mWebView.setWebViewClient(new WebViewClient());
          mWebView.setWebChromeClient(new WebChromeClient());
          mWebView.loadUrl(urlName);
          return view;

//        // Inflate the layout for this fragment
//        RecyclerView recyclerView= (RecyclerView) inflater.inflate(R.layout.fragment_web_list, container, false);
//        setUpRecyclerView(recyclerView);
//        return recyclerView;
    }

    @Override
    public void onPause() {
        super.onPause();
        mWebView.onPause();
        mWebView.pauseTimers();
    }

    @Override
    public void onResume() {
        super.onResume();
        mWebView.resumeTimers();
        mWebView.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mWebView.destroy();
        mWebView = null;
    }


//    private void setUpRecyclerView(RecyclerView recyclerView) {
//        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
//        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(),
//                WebSites.sUrlsStrings));
//    }

//    private List<String> getRandomSublist(String[] array, int amount) {
//        ArrayList<String> list = new ArrayList<>(amount);
//        Random random = new Random();
//        while (list.size() < amount) {
//            list.add(array[random.nextInt(array.length)]);
//        }
//        return list;
//    }

//    public static class SimpleStringRecyclerViewAdapter
//            extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {
//
//        private final TypedValue mTypedValue = new TypedValue();
//        private int mBackground;
//        private List<String> mValues;
//
//        public static class ViewHolder extends RecyclerView.ViewHolder {
//            public String mBoundString;
//
//            public final View mView;
//            public final WebView mWebView;
//            public final TextView mTextView;
//
//            public ViewHolder(View view) {
//                super(view);
//                mView = view;
//                mWebView = (WebView) view.findViewById(R.id.webview);
//                mTextView = (TextView) view.findViewById(android.R.id.text1);
//            }
//
//            @Override
//            public String toString() {
//                return super.toString() + " '" + mTextView.getText();
//            }
//        }
//
//        public String getValueAt(int position) {
//            return mValues.get(position);
//        }
//
//        public SimpleStringRecyclerViewAdapter(Context context, List<String> items) {
//            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
//            mBackground = mTypedValue.resourceId;
//            mValues = items;
//        }
//
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.list_item, parent, false);
//            view.setBackgroundResource(mBackground);
//            return new ViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(final ViewHolder holder, int position) {
//            holder.mBoundString = mValues.get(position);
////            holder.mTextView.setText(mValues.get(position));
//
//            holder.mWebView.loadUrl(mValues.get(position));
//
//            holder.mView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Context context = v.getContext();
//                    Intent intent = new Intent(context, WebSiteDetailActivity.class);
//                    intent.putExtra(WebSiteDetailActivity.EXTRA_NAME, holder.mBoundString);
//
//                    context.startActivity(intent);
//                }
//            });
//
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return mValues.size();
//        }
//    }
}
