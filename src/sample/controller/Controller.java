package sample.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.model.*;
import sample.view.View;

import java.io.IOException;
import java.util.stream.Collectors;

public class Controller extends Application {

    private View theView = new View();
    private Timeline timelineOfFirstButton;
    private Timeline timelineOfSecondButton;
    private Timeline timelineOfThirdButton;
    private Timeline timelineOfFourthButton;
    private TransactionThread firstTransactionThread = new TransactionThread(1, 100);
    private TransactionThread secondTransactionThread = new TransactionThread(101, 1000);
    private TransactionThread thirdTransactionThread = new TransactionThread(1001, 10000);
    private TransactionService  transactionService = new TransactionService();
    private boolean switcher = true;

    public Controller() throws IOException {
        initialize();
    }

    @Override
    public void start(Stage stage) throws Exception {
        theView.start(stage);

        View.getElements().getButtonStartFirstThread().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(switcher) {
                    timelineOfFirstButton.play();
                    switcher = false;
                    View.getElements().getButtonStartFirstThread().setText("Stop");
                } else {
                    timelineOfFirstButton.pause();
                    switcher = true;
                    View.getElements().getButtonStartFirstThread().setText("Start");
                }
            }
        });

        View.getElements().getButtonStartSecondThread().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(switcher) {
                    timelineOfSecondButton.play();
                    switcher = false;
                    View.getElements().getButtonStartSecondThread().setText("Stop");
                } else {
                    timelineOfSecondButton.pause();
                    switcher = true;
                    View.getElements().getButtonStartSecondThread().setText("Start");
                }
            }
        });

        View.getElements().getButtonStartThirdThread().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(switcher) {
                    timelineOfThirdButton.play();
                    switcher = false;
                    View.getElements().getButtonStartThirdThread().setText("Stop");
                } else {
                    timelineOfThirdButton.pause();
                    switcher = true;
                    View.getElements().getButtonStartThirdThread().setText("Start");
                }
            }
        });

        View.getElements().getButtonStartAllOfThreads().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(switcher) {
                    timelineOfFourthButton.play();
                    switcher = false;
                    View.getElements().getButtonStartAllOfThreads().setText("Stop");
                } else {
                    timelineOfFourthButton.pause();
                    switcher = true;
                    View.getElements().getButtonStartAllOfThreads().setText("Start");
                }
            }
        });

    }

    private void initialize() {
        timelineOfFirstButton = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    onActionFirstButton(View.getElements().getTextOfCurrentHoldSum());
                    setTableValuesFromList(View.getElements().getTableViewOfFirstThread(), 1, 100);
                    setTableValuesOfDeletedElements(View.getElements().getTableViewOutFromList(), 1, 10000);

                    View.getElements().setAbscissa(View.getElements().getAbscissa() + 1);
                    View.getElements().getSeries().getData()
                            .add(new XYChart.Data
                                    (View.getElements().getAbscissa()
                                            , ListOfTransactions.getList()
                                            .stream().mapToLong(Transaction::getValueOfTransaction).sum()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));
        timelineOfFirstButton.setCycleCount(Timeline.INDEFINITE);
        timelineOfFirstButton.setAutoReverse(false);

        timelineOfSecondButton = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    onActionSecondButton((View.getElements().getTextOfCurrentHoldSum()));
                    setTableValuesFromList(View.getElements().getTableViewOfSecondThread(), 101, 1000);
                    setTableValuesOfDeletedElements(View.getElements().getTableViewOutFromList(), 1, 10000);

                    View.getElements().setAbscissa(View.getElements().getAbscissa() + 1);
                    View.getElements().getSeries().getData()
                            .add(new XYChart.Data
                                    (View.getElements().getAbscissa()
                                            , ListOfTransactions.getList()
                                            .stream().mapToLong(Transaction::getValueOfTransaction).sum()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));
        timelineOfSecondButton.setCycleCount(Timeline.INDEFINITE);
        timelineOfSecondButton.setAutoReverse(false);

        timelineOfThirdButton = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    onActionThirdButton(View.getElements().getTextOfCurrentHoldSum());
                    setTableValuesFromList(View.getElements().getTableViewOfThirdThread(), 1001, 10000);
                    setTableValuesOfDeletedElements(View.getElements().getTableViewOutFromList(), 1, 10000);

                    View.getElements().setAbscissa(View.getElements().getAbscissa() + 1);
                    View.getElements().getSeries().getData()
                            .add(new XYChart.Data
                                    (View.getElements().getAbscissa()
                                            , ListOfTransactions.getList()
                                            .stream().mapToLong(Transaction::getValueOfTransaction).sum()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));
        timelineOfThirdButton.setCycleCount(Timeline.INDEFINITE);
        timelineOfThirdButton.setAutoReverse(false);

        timelineOfFourthButton = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    onActionFourthButton(View.getElements().getTextOfCurrentHoldSum());
                    setTableValuesFromList(View.getElements().getTableViewOfFirstThread(), 1, 100);
                    setTableValuesFromList(View.getElements().getTableViewOfSecondThread(), 101, 1000);
                    setTableValuesFromList(View.getElements().getTableViewOfThirdThread(), 1001, 10000);
                    setTableValuesOfDeletedElements(View.getElements().getTableViewOutFromList(), 1, 10000);

                    View.getElements().setAbscissa(View.getElements().getAbscissa() + 1);
                    View.getElements().getSeries().getData()
                            .add(new XYChart.Data
                                    (View.getElements().getAbscissa()
                                            , ListOfTransactions.getList()
                                            .stream().mapToLong(Transaction::getValueOfTransaction).sum()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));
        timelineOfFourthButton.setCycleCount(Timeline.INDEFINITE);
        timelineOfFourthButton.setAutoReverse(false);
    }

    private void onActionFirstButton(Text text) {
        firstTransactionThread.run();
        transactionService.run();
        setTextOfSum(text);
    }

    private void onActionSecondButton(Text text) {
        secondTransactionThread.run();
        transactionService.run();
        setTextOfSum(text);
    }

    private void onActionThirdButton(Text text) {
        thirdTransactionThread.run();
        transactionService.run();
        setTextOfSum(text);
    }

    private void onActionFourthButton(Text text) {
        firstTransactionThread.run();
        secondTransactionThread.run();
        thirdTransactionThread.run();
        transactionService.run();
        setTextOfSum(text);
    }

    private void setTextOfSum(Text text) {
        text.setText(String.valueOf(
                ListOfTransactions.getList()
                        .stream().mapToLong(Transaction::getValueOfTransaction)
                        .sum()));
    }
    //get all of the transactions
    private void setTableValuesFromList(TableView<Transaction> table, int min, int max) throws IOException {
        table.getItems().clear();
        table.setItems(FXCollections.observableArrayList
                (ListOfTransactions.getList()
                        .stream().filter(transaction -> transaction.getValueOfTransaction() <= max
                                && transaction.getValueOfTransaction() >= min)
                        .collect(Collectors.toList())));
    }

    private void setTableValuesOfDeletedElements(TableView<Transaction> table, int min, int max) throws IOException {
        table.getItems().clear();
        table.setItems(FXCollections.observableArrayList
                (ListOfDeletedElements.getList()
                        .stream().filter(transaction -> transaction.getValueOfTransaction() <= max
                                && transaction.getValueOfTransaction() >= min)
                        .collect(Collectors.toList())));
    }

}
