package org.iortega.board.application.usecase;

import org.iortega.board.application.domain.entity.Game;
import org.iortega.board.application.domain.port.GameRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GetGamesSummary {

    private GameRepository GameRepository;

    public GetGamesSummary(GameRepository GameRepository) {
        this.GameRepository = GameRepository;
    }

    public List<String> exec() {
        return GameRepository.getAllGames().stream()
                .sorted(Comparator
                        .comparingInt(Game::getSumScore)
                        .thenComparing(Game::getIndex)
                        .reversed())
                .map(Game::getGameSummary)
                .collect(Collectors.toList());
    }
}
