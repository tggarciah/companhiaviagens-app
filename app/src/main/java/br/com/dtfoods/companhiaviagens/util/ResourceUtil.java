package br.com.dtfoods.companhiaviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourceUtil {

   public static Drawable devolverDrawable(Context context, String drawableEmTexto) {
      Resources resources = context.getResources();
      int idDoDrawable = resources.getIdentifier(drawableEmTexto, "drawable", context.getPackageName());
      Drawable drawableImagemPacote = resources.getDrawable(idDoDrawable);
      return drawableImagemPacote;
   }

}
