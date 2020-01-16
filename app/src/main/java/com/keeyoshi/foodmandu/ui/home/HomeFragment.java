package com.keeyoshi.foodmandu.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.keeyoshi.foodmandu.API.FlavoursAPI;
import com.keeyoshi.foodmandu.API.Superapi;
import com.keeyoshi.foodmandu.Model.Flavours;
import com.keeyoshi.foodmandu.R;
import com.keeyoshi.foodmandu.URL.url;
import com.keeyoshi.foodmandu.ui.home.Adapter.BakeriesAdapter;
import com.keeyoshi.foodmandu.ui.home.Adapter.CategoryAdapter;
import com.keeyoshi.foodmandu.ui.home.Adapter.FlavoursAdapter;
import com.keeyoshi.foodmandu.ui.home.Adapter.SuperAdaptar;
import com.keeyoshi.foodmandu.ui.home.Adapter.ViewPagerAdapter;
import com.keeyoshi.foodmandu.ui.home.Model.BakeriesViewModel;
import com.keeyoshi.foodmandu.ui.home.Model.HomeViewModel;
import com.keeyoshi.foodmandu.ui.home.Model.Super7;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

   // private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private RecyclerView SuperRecyclerView;
    private RecyclerView BakeriesRecyclerView;
    private RecyclerView FlavourRecyclerView;
    ViewPager viewPager;

    //Adapters
    SuperAdaptar superAdaptar;
    FlavoursAdapter flavoursAdapter;

    //Model class
    public static List<HomeViewModel> categoryList=new ArrayList<>();
    public static List<BakeriesViewModel> bakeriesList=new ArrayList<>();
    List<Super7> superList;
    List<Flavours> flavoursList;


    //Image slider scrolling automatically
    private int position;
    private static final int PAGE_NUM=4;
    private Handler handler=new Handler();
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            viewPager.setCurrentItem(position,true);
            if(position>=PAGE_NUM) position=0;
            else position++;
            handler.postDelayed(runnable,3000);
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = view.findViewById(R.id.viewpager);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(viewPagerAdapter);
        runnable.run();


        recyclerView=view.findViewById(R.id.recycler);
        HomeViewModel homeViewModel=new HomeViewModel(R.drawable.food);
        categoryList=homeViewModel.getListcategory();
        categoryList.add(new HomeViewModel(R.drawable.restaurent));
        categoryList.add(new HomeViewModel(R.drawable.liquare));
        categoryList.add(new HomeViewModel(R.drawable.refreshment));
        categoryList.add(new HomeViewModel(R.drawable.organic));
        categoryList.add(new HomeViewModel(R.drawable.ice));

        CategoryAdapter categoryAdapter=new CategoryAdapter(getActivity(),categoryList);
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));




        //super7 items and image are fetch using API
        SuperRecyclerView=view.findViewById(R.id.recyclerSuper);
        superList=new ArrayList<>();
        Superapi superapi = url.getInstance().create(Superapi.class);
        Call<List<Super7>> listCall = superapi.getsuper();
        Call<Super7> call = superapi.getsuperimage(url.token);
        listCall.enqueue(new Callback<List<Super7>>() {
            @Override
            public void onResponse(Call<List<Super7>> call, Response<List<Super7>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Code Error" + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                        superList = response.body();
                        SuperAdaptar superAdapter=new SuperAdaptar(getActivity(),superList);
                        SuperRecyclerView.setAdapter(superAdapter);
                        SuperRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
            }

            @Override
            public void onFailure(Call<List<Super7>> call, Throwable t) {

                Toast.makeText(getActivity(), "Error" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

        call.enqueue(new Callback<Super7>() {
            @Override
            public void onResponse(Call<Super7> call, Response<Super7> response) {

            }

            @Override
            public void onFailure(Call<Super7> call, Throwable t) {

            }
        });












        BakeriesRecyclerView=view.findViewById(R.id.bakeriesRecycler);
        BakeriesViewModel bakeriesViewModel=new BakeriesViewModel(R.drawable.susage,"Chocolote");
        bakeriesList=bakeriesViewModel.getBakeriesList();
        bakeriesList.add(new BakeriesViewModel(R.drawable.chocolates,"Chocolate"));
        bakeriesList.add(new BakeriesViewModel(R.drawable.cake,"Cakes"));
        bakeriesList.add(new BakeriesViewModel(R.drawable.cookies,"Cream cookies"));
        bakeriesList.add(new BakeriesViewModel(R.drawable.choco,"Choco Cream"));
        bakeriesList.add(new BakeriesViewModel(R.drawable.fine_cakes,"Fine Cakes"));
        bakeriesList.add(new BakeriesViewModel(R.drawable.chocolates,"Chocolates"));
        BakeriesAdapter bakeriesAdapter=new BakeriesAdapter(getActivity(),bakeriesList);
        BakeriesRecyclerView.setAdapter(bakeriesAdapter);
        BakeriesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));





        //flavours items and image fetch using API
        FlavourRecyclerView=view.findViewById(R.id.recyclerflavour);
        flavoursList=new ArrayList<>();
        final FlavoursAPI flavoursAPI = url.getInstance().create(FlavoursAPI.class);
        Call<List<Flavours>> ListCall = flavoursAPI.getflavours();
        Call<Flavours> Call = flavoursAPI.getflavoursimage(url.token);
        ListCall.enqueue(new Callback<List<Flavours>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Flavours>> call, Response<List<Flavours>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getContext(), "Code Error" + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                flavoursList=response.body();
                FlavoursAdapter flavoursAdapter=new FlavoursAdapter(getActivity(),flavoursList);
                FlavourRecyclerView.setAdapter(flavoursAdapter);
                FlavourRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
            }

            @Override
            public void onFailure(retrofit2.Call<List<Flavours>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });


        Call.enqueue(new Callback<Flavours>() {
            @Override
            public void onResponse(retrofit2.Call<Flavours> call, Response<Flavours> response) {

            }

            @Override
            public void onFailure(retrofit2.Call<Flavours> call, Throwable t) {

            }
        });


        return view;

    }


}