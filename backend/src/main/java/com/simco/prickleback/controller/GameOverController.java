package com.simco.prickleback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.simco.prickleback.model.Band;
import com.simco.prickleback.model.Score;
import com.simco.prickleback.model.Tour;

@Controller
public class GameOverController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GameOverController.class);

    @GetMapping("/game-over")
    public ModelAndView showGameOver(
            @ModelAttribute("currentBand") Band currentBand,
            @ModelAttribute("currentTour") Tour currentTour,
            ModelMap model) {

        logger.info("showGameOver() invoked");

        // tabulate final scoring for display
        Score score = currentTour.getCurrentScore();

        // TODO: get appropriate quote for display

        // add session variables
        // add data necessary to render view
        model.addAttribute("score", score);
        return new ModelAndView("completion", model);
    }

}
