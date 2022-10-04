package com.example.demo.controllers;

import com.example.demo.entities.Movies;
import com.example.demo.services.MovieImpl;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("movie")

public class MovieController {

    @Autowired
    MovieImpl mi;

    @GetMapping("/list")
    public String allMoviesList(ModelMap mm) {

        mm.addAttribute("listmovies", mi.allMovies());

        return "redirect:/movie/rediricttoallmovies";
    }
    
    
    
    @GetMapping("/insert/form")
    public String movieInsertForm(ModelMap mm) {

        mm.addAttribute("newmovie", new Movies());

        return "insertmovieform";
    }

    /**
     *
     * @ModelAttribute επελεξα αυτον τον τροπο αντι του @PathVariable λογο
     * πολλων πεδιων.
     *
     */
    @PostMapping("/doinsert")
    public String movieDoInsert(@ModelAttribute("newmovie") Movies movie) {

        LocalDateTime now = LocalDateTime.now();
        Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        movie.setMovieAdded(date);

        mi.insertMovie(movie);

        return "redirect:/movie/rediricttoallmovies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Integer id) {

        Movies movie = mi.GetById(id);

        mi.deleteMovie(movie);

        return "redirect:/movie/rediricttoallmovies";
    }

    @GetMapping("/update/{movieid}")
    public String movieUpdateForm(@PathVariable Integer movieid, ModelMap mm) {

        Movies movie = mi.GetById(movieid);

        mm.addAttribute("movieupdate", movie);

        return "movieupdateform";
    }

    @PostMapping("/doupdate")
    public String movieUpdateForm(@ModelAttribute("newmovie") Movies movie) {

        mi.insertMovie(movie);

        return "redirect:/movie/rediricttoallmovies";
    }

    @GetMapping("/rediricttoallmovies")
    public String showAllMovies(ModelMap mm) {

        mm.addAttribute("listmovies", mi.allMovies());

        return "allmovies";
    }

    //----------- Movie Categories --------------- //
    @GetMapping("/category/comedy")
    public String categoryComedy(ModelMap mm) {

        mm.addAttribute("listcomedies", mi.getMovieListByCategoryId());
        System.out.println(mi.getMovieListByCategoryId());
        return "comedies";
    }

    @GetMapping("/category/thriller")
    public String categoryThriller(ModelMap mm) {

        mm.addAttribute("listthrillers", mi.getMovieListByCategoryId1());

        return "thriller";
    }

    @GetMapping("/category/horror")
    public String categoryHorror(ModelMap mm) {

        mm.addAttribute("listhorrors", mi.getMovieListByCategoryId2());

        return "horror";
    }

    @GetMapping("/category/action")
    public String categoryAction(ModelMap mm) {

        mm.addAttribute("listactions", mi.getMovieListByCategoryId3());

        return "action";
    }

    
    @GetMapping("/category/sport")
    public String categorySport(ModelMap mm) {

        mm.addAttribute("listsports", mi.getMovieListByCategoryId4());

        return "sport";
    }

    @GetMapping("/category/drama")
    public String categoryDrama(ModelMap mm) {

        mm.addAttribute("listdramas", mi.getMovieListByCategoryId5());

        return "drama";
    }

    //-----------End of Movie Categories --------------- //
    
    
    
    
    
    // --------- Shopping Cart ---------- //
    @GetMapping("/buy/{id}")
    public String buy(
            @PathVariable Integer id,
            ModelMap mm,
            HttpSession session) {

        // 1) Τσεκάρω εαν το cart είναι άδειο //
        if (session.getAttribute("cart") == null) {

            List<Movies> cart = new ArrayList();
            cart.add(mi.GetById(id));
//            mm.addAttribute("movie", mi.GetById(id));
            
            session.setAttribute("cart", cart);
            System.out.println(cart + "first if");
            
        } 
        else {

            //3) castαρο το Object του session σε List<Movies> //
            List<Movies> cart = (List<Movies>) session.getAttribute("cart");
            cart.add(mi.GetById(id));

            session.setAttribute("cart", cart);
   
        }

        return "cartorder";
    }

    // isExisting checker //
    private int isExisting(int id, HttpSession session) {

        List<Movies> cart = (List<Movies>) session.getAttribute("cart");

        for (int i = 0; i < cart.size(); i++) {

            if (cart.get(i).getMovieId() == id) {

                return i;
            }

        }
        return -1;
    }
    
//    @GetMapping ("/takemovie/{id}")
//    public String takemovie (@PathVariable Integer id, ModelMap mm) {
//    
//        Movies movie = mi.GetById(id);
//        mm.addAttribute("movie", movie);
//        System.out.println(movie);
//        
//        return "watchmovie";
//    }
    
 // --------- Delete Movie From Cart --------- //
@GetMapping("/cartdelete/{id}")
public String deletefromcart(@PathVariable ("id") Integer movieId, HttpSession session) {

    List<Movies> cart = (List<Movies>) session.getAttribute("cart");
    int index = isExisting(movieId, session);
    cart.remove(index);
    session.setAttribute("cart", cart);
    
    return "cartorder";
}



// ----- Show Movie Page ------ //
@GetMapping("/watch/{id}")
public String watchMovie(@PathVariable Integer id, ModelMap mm, HttpSession session) {
    Movies movie = mi.GetById(id);
    mm.addAttribute("movie", movie);
//    List<Movies> cart = (List<Movies>) session.getAttribute("cart");
    System.out.println(movie);

    return "watchmovie";
}

// -------- Show Cart ------- //
@GetMapping ("/showcart")
public String showCart() {

    return "cartorder";
}


// ------ Show Payment Page ------ //
@GetMapping("/payment")
public String payment(HttpSession session){
    
    session.getAttribute("cart");
    
    return "payment";
}

// -------- PAYMENT ---------- //

@GetMapping("/proccedtopayment")
    public String proccedToPayment(HttpSession session) {
    
        List<Movies> cart = (List<Movies>) session.getAttribute("cart");
        List<Movies> pay = new ArrayList<>();
        
        for (int i = 0; i < cart.size(); i++) {
           
            
            cart.get(i).setMovieQuantity(cart.get(i).getMovieQuantity() - 1);
            System.out.println(cart.get(i).getMovieQuantity() - 1);
            
        }
        
        return "";
    }

}
