package com.eebbk.open.scrollphotoitem.expandablelayout.multitype;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.eebbk.open.scrollphotoitem.R;
import com.eebbk.open.scrollphotoitem.expandablelayout.bean.DisplayCharacterBean;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.ClassLinker;
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.MultiTypeAdapter;

import static me.drakeet.multitype.MultiTypeAsserts.assertAllRegistered;
import static me.drakeet.multitype.MultiTypeAsserts.assertHasTheSameAdapter;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2018/1/25 9:27
 * Email:  369013520@qq.com
 */

public class OneDataToManyActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MultiTypeAdapter adapter;

    TextView mSuspensionBar;
    int mCurrentPosition = 0;
    int mSuspensionHeight;
//    List<Data> dataList;
    List<DisplayCharacterBean> dataList;
    View view;
    private View viewLast;
    DisplayCharacterBean displayCharacterBean;
    private String character = " character ";
    private String phonetic = " phonetic ";
    private String phoneticVoiceVo = " phoneticVoiceVo ";
    private String phoneticSequence = " phoneticSequence ";
    private String polyphone = " polyphone ";
    private String radicals = " radicals ";
    private String strokes = " strokes ";
    private String structure = " structure ";
    private String strokesOrderUrl = " strokesOrderUrl ";
    private String characterSimilarity = " fallibilityHint ";
    private String fallibilityHint = " fallibilityHint ";
    private String diagrammatizeUrl = " diagrammatizeUrl ";
    private String characterParaphrase = " characterParaphrase ";
    private String characterSynonym = " characterSynonym ";
    private String characterAntonym = " characterAntonym ";
    private String characterSentence = " characterSentence ";
    private String combineWords = " combineWords ";
    private String characterOriginVideoUrl = " characterOriginVideoUrl ";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initData();

        mSuspensionBar = (TextView) findViewById(R.id.tv_header);

        recyclerView = (RecyclerView) findViewById(R.id.list);
        adapter = new MultiTypeAdapter();

        adapter.register(DisplayCharacterBean.class).to(
                new DataType1ViewBinder(),
                new DataType2ViewBinder()
        ).withClassLinker(new ClassLinker<DisplayCharacterBean>() {
            @NonNull
            @Override
            public Class<? extends ItemViewBinder<DisplayCharacterBean, ?>> index(@NonNull DisplayCharacterBean data) {
                if (data.getType() == Data.TYPE_1) {
                    return DataType1ViewBinder.class;
                } else {
                    return DataType2ViewBinder.class;
                }
            }
        });

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        dataList = getDataFromService();
        adapter.setItems(dataList);
        adapter.notifyDataSetChanged();
        assertAllRegistered(adapter, dataList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        assertHasTheSameAdapter(recyclerView, adapter);

        mSuspensionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewLast != null) {
                    Log.i("OneDataToManyActivity", "mCurrentPosition: " + mCurrentPosition
                            + " type = " + dataList.get(mCurrentPosition).type);
                    if (dataList.get(mCurrentPosition).type == Data.TYPE_1) {
                        DataType1ViewBinder.ViewHolder viewHolder = (DataType1ViewBinder.ViewHolder)
                                recyclerView.getChildViewHolder(viewLast);
                        viewHolder.expandableLayout.show();
                    }
                }
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mSuspensionHeight = mSuspensionBar.getHeight();
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                view = linearLayoutManager.findViewByPosition(mCurrentPosition + 1);
                if (view != null) {
                    if (view.getTop() <= mSuspensionHeight) {
                        mSuspensionBar.setY(-(mSuspensionHeight - view.getTop()));
                    } else {
                        mSuspensionBar.setY(0);
                    }
                }
                if (mCurrentPosition != linearLayoutManager.findFirstVisibleItemPosition()) {
                    mCurrentPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    mSuspensionBar.setY(0);

                    updateSuspensionBar();
                }
                viewLast = linearLayoutManager.findViewByPosition(mCurrentPosition);
            }
        });
    }

    private void initData() {
        displayCharacterBean = new DisplayCharacterBean(1);
        displayCharacterBean.setWord(character)
                .setPhonetic(phonetic)
                .setPhoneticVoiceVo(phoneticVoiceVo)
                .setPhoneticSequence(phoneticSequence)
                .setPolyphone(polyphone)
                .setRadicals(radicals)
                .setStrokes(strokes)
                .setStructure(structure)
                .setStrokesOrderUrl(strokesOrderUrl)
                .setCharacterSimilarity(characterSimilarity)
                .setFallibilityHint(fallibilityHint)
                .setDiagrammatizeUrl(diagrammatizeUrl)
                .setCharacterParaphrase(characterParaphrase)
                .setCharacterSynonym(characterSynonym)
                .setCharacterAntonym(characterAntonym)
                .setCharacterSentence(characterSentence)
                .setCombineWords(combineWords)
                .setCharacterOriginVideoUrl(characterOriginVideoUrl);
    }

//    List<Data> getDataFromService() {
//        List<Data> list = new ArrayList<>();
//        for (int i = 0; i < 30; i = i + 2) {
//            list.add(new Data("title: " + i, Data.TYPE_1));
//            list.add(new Data("title: " + i + 1, Data.TYPE_2));
//        }
//        return list;
//    }

    List<DisplayCharacterBean> getDataFromService() {
        List<DisplayCharacterBean> list = new ArrayList<>();
        for (int i = 0; i < 30; i = i + 2) {

            DisplayCharacterBean displayCharacterBean = new DisplayCharacterBean(DisplayCharacterBean.TYPE_1);
            displayCharacterBean.setWord(character)
                    .setPhonetic(phonetic)
                    .setPhoneticVoiceVo(phoneticVoiceVo)
                    .setPhoneticSequence(phoneticSequence)
                    .setPolyphone(polyphone)
                    .setRadicals(radicals)
                    .setStrokes(strokes)
                    .setStructure(structure)
                    .setStrokesOrderUrl(strokesOrderUrl)
                    .setCharacterSimilarity(characterSimilarity)
                    .setFallibilityHint(fallibilityHint)
                    .setDiagrammatizeUrl(diagrammatizeUrl)
                    .setCharacterParaphrase(characterParaphrase)
                    .setCharacterSynonym(characterSynonym)
                    .setCharacterAntonym(characterAntonym)
                    .setCharacterSentence(characterSentence)
                    .setCombineWords(combineWords)
                    .setCharacterOriginVideoUrl(characterOriginVideoUrl);

            list.add(displayCharacterBean);

            DisplayCharacterBean displayCharacterBean2 = new DisplayCharacterBean(DisplayCharacterBean.TYPE_2);
            displayCharacterBean2.setWord(character)
                    .setPhonetic(phonetic)
                    .setPhoneticVoiceVo(phoneticVoiceVo)
                    .setPhoneticSequence(phoneticSequence)
                    .setPolyphone(polyphone)
                    .setRadicals(radicals)
                    .setStrokes(strokes)
                    .setStructure(structure)
                    .setStrokesOrderUrl(strokesOrderUrl)
                    .setCharacterSimilarity(characterSimilarity)
                    .setFallibilityHint(fallibilityHint)
                    .setDiagrammatizeUrl(diagrammatizeUrl)
                    .setCharacterParaphrase(characterParaphrase)
                    .setCharacterSynonym(characterSynonym)
                    .setCharacterAntonym(characterAntonym)
                    .setCharacterSentence(characterSentence)
                    .setCombineWords(combineWords)
                    .setCharacterOriginVideoUrl(characterOriginVideoUrl);
            list.add(displayCharacterBean2);
        }
        return list;
    }

    private void updateSuspensionBar() {
        mSuspensionBar.setText("Taeyeon " + mCurrentPosition + " header " + dataList.get(mCurrentPosition).getWord());
    }
}
