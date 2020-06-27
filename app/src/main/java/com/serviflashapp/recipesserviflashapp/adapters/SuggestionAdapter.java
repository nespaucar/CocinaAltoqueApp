package com.serviflashapp.recipesserviflashapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviflashapp.recipesserviflashapp.MainActivity;
import com.serviflashapp.recipesserviflashapp.R;
import com.serviflashapp.recipesserviflashapp.models.Suggestion;

import java.util.ArrayList;

public class SuggestionAdapter extends RecyclerView.Adapter<SuggestionAdapter.ViewHolderSuggestion> implements Filterable {
    private ArrayList<Suggestion> suggestion;
    private ArrayList<Suggestion> suggestionfull;
    private Context context;
    private MainActivity mainActivity;

    public SuggestionAdapter(ArrayList<Suggestion> suggestion, Context context, MainActivity mainActivity) {
        this.suggestion = suggestion;
        this.suggestionfull = new ArrayList<Suggestion>(suggestion);
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ViewHolderSuggestion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_suggestion, null, false);
        return new ViewHolderSuggestion(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuggestionAdapter.ViewHolderSuggestion holder, int position) {
    }

    @Override
    public int getItemCount() {
        return suggestionfull.size();
    }

    @Override
    public Filter getFilter() {
        return SuggestionFilter;
    }

    private Filter SuggestionFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Suggestion> filteredList = new ArrayList<Suggestion>();
            if (constraint == null && constraint.length() == 0) {
                filteredList.addAll(suggestionfull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Suggestion suggestionB : suggestionfull) {
                    if (suggestionB.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(suggestionB);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            suggestionfull.clear();
            suggestionfull.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolderSuggestion extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ViewHolderSuggestion(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View v) {
            final int position = getAdapterPosition();
        }
    }
}