package br.com.bernardino.bankapplication.statement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.bernardino.bankapplication.R;
import br.com.bernardino.bankapplication.model.StatementTO;
import br.com.bernardino.bankapplication.utils.Utils;

public class StatementAdapter extends RecyclerView.Adapter<StatementAdapter.StatementViewHolder> {

    private List<StatementTO> statements;
    private Context mContext;

    public StatementAdapter(List<StatementTO> statements, Context context) {
        this.statements = statements;
        this.mContext = context;
    }

    @NonNull
    @Override
    public StatementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.statement_list_item, parent, false);
        StatementViewHolder holder = new StatementViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StatementViewHolder holder, int position) {
        StatementTO statement = statements.get(position);
        holder.mTextViewStatementTitle.setText(statement.getTitle());
        holder.mTextViewStatementDesc.setText(statement.getDesc());
        holder.mTextViewStatementValue.setText(String.valueOf(statement.getValue()));
        holder.mTextViewDate.setText(Utils.formatDate(statement.getDate()));
    }

    @Override
    public int getItemCount() {
        return statements!=null && !statements.isEmpty() ? statements.size() : 0;
    }

    static class StatementViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewStatementTitle;
        public TextView mTextViewStatementDesc;
        public TextView mTextViewStatementValue;
        public TextView mTextViewDate;


        StatementViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewStatementTitle = itemView.findViewById(R.id.tv_statement_title);
            mTextViewStatementDesc = itemView.findViewById(R.id.tv_statement_desc);
            mTextViewStatementValue = itemView.findViewById(R.id.tv_statement_value);
            mTextViewDate = itemView.findViewById(R.id.date);
        }
    }
}
