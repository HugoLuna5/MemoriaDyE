package lunainc.com.mx.menoriadye.Fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;

import java.util.ArrayList;
import java.util.List;

import lunainc.com.mx.menoriadye.R;
import lunainc.com.mx.menoriadye.adapter.ContactsAdapter;
import lunainc.com.mx.menoriadye.model.Contact;
import lunainc.com.mx.menoriadye.utils.MyDividerItemDecoration;

public class EstaticaFragment extends Fragment {



    private RecyclerView recyclerView;
    private List<Contact> contactList;
    private ContactsAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = FragmentPagerItem.getPosition(getArguments());



        recyclerView = view.findViewById(R.id.recyclerview);
        contactList = new ArrayList<>();
        mAdapter = new ContactsAdapter(getActivity(), contactList);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL, 36));
        recyclerView.setAdapter(mAdapter);

        fetchContacts();

    }

    private void fetchContacts() {

        List<Contact> items = new ArrayList<>();
        Contact entry1=new Contact("Prueba", "","78910055104");
        Contact entry2=new Contact("Prueba 2","","78910055104");
        Contact entry3=new Contact("Prueba 3","","78910055104");
        Contact entry4=new Contact("Prueba 4","","78910055104");
        Contact entry5=new Contact("Prueba 5","","78910055104");

        items.add(entry1);
        items.add(entry2);
        items.add(entry3);
        items.add(entry4);
        items.add(entry5);

        contactList.clear();
        contactList.addAll(items);

        // refreshing recycler view
        mAdapter.notifyDataSetChanged();


    }




    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getActivity().getWindow().setStatusBarColor(Color.WHITE);
        }
    }

}
