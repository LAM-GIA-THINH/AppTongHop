package com.example.giuaky;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {
    ListView lvBook;
    ArrayList<Book> arrayBook;
    Book_adapter adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        lvBook = (ListView) view.findViewById(R.id.listViewBook);
        arrayBook = new ArrayList<>();
        arrayBook.add(new Book("M??y t??nh","M??y t??nh Casio",R.drawable.caculator));
        arrayBook.add(new Book("V???","V??? b??i t???p",R.drawable.notebook));
        arrayBook.add(new Book("B??t ch??","B??t ch?? 2B",R.drawable.pencil));
        arrayBook.add(new Book("T???y","T???y b??t ch?? Steadler",R.drawable.tay));
        arrayBook.add(new Book("Compa","Compa deli",R.drawable.compa));
        arrayBook.add(new Book("Th?????c", "Th?????c k??? nh???a",R.drawable.thuoc));
        arrayBook.add(new Book("K??o", "K??o h???c sinh",R.drawable.keo));
        arrayBook.add(new Book("X???y gi???y", "X???y gi???y A4 JKPlus",R.drawable.xapgiay));

        arrayBook.add(new Book("M??y t??nh","M??y t??nh Casio",R.drawable.caculator));
        arrayBook.add(new Book("V???","V??? b??i t???p",R.drawable.notebook));
        arrayBook.add(new Book("B??t ch??","B??t ch?? 2B",R.drawable.pencil));
        arrayBook.add(new Book("T???y","T???y b??t ch?? Steadler",R.drawable.tay));
        arrayBook.add(new Book("Compa","Compa deli",R.drawable.compa));
        arrayBook.add(new Book("Th?????c", "Th?????c k??? nh???a",R.drawable.thuoc));
        arrayBook.add(new Book("K??o", "K??o h???c sinh",R.drawable.keo));
        arrayBook.add(new Book("X???y gi???y", "X???y gi???y A4 JKPlus",R.drawable.xapgiay));

        adapter = new Book_adapter( getActivity(),R.layout.book,arrayBook);
        lvBook.setAdapter(adapter);
        lvBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), OpenList.class);
                intent.putExtra("T??n",arrayBook.get(i).getTen());
                intent.putExtra("M?? t???",arrayBook.get(i).getMoTa());
                intent.putExtra("Hinh",arrayBook.get(i).getHinh());
                startActivity(intent);


            }
        });
        lvBook.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                openDialog(i);
                return false;
            }
        });

        return view;
    }
    private void openDialog(int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Th??ng b??o");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("B???n c?? mu???n xo???");
        alertDialog.setPositiveButton("C??", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayBook.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("Kh??ng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }

}