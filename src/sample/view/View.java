package sample.view;

/* GUIThreadsClearFinally
 *
 * variant 2
 *
 * by Andrukh Sergey
 * 243(2), IFTKN,
 * department Software Engineering
 *
 * 10/30/19
 *
 * (c) YDFD corporated
 */

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sample.model.ListOfTransactions;
import sample.model.Transaction;

import java.io.IOException;
import java.util.stream.Collectors;

public class View extends Application {
    private static Elements elements;

    public static class Elements{
        private static int abscissa = 0;

        private static XYChart.Series series;

        private static Scene scene;

        private static VBox vBoxOfFirstTable;
        private static VBox vBoxOfSecondTable;
        private static VBox vBoxOfThirdTable;
        private static VBox vBoxOfOutTable;
        private static VBox vBoxOfTextAndChart;

        private static HBox hBoxOfThreeThreadsTables;
        private static HBox hBoxOfTextAndButton;
        private static HBox hBoxContainerOfAllBoxes;

        private static TableView<Transaction> tableViewOfFirstThread;
        private static TableView<Transaction> tableViewOfSecondThread;
        private static TableView<Transaction> tableViewOfThirdThread;
        private static TableView<Transaction> tableViewOutFromList;

        private static LineChart<Number,Number> lineChart;

        private static Button buttonStartFirstThread;
        private static Button buttonStartSecondThread;
        private static Button buttonStartThirdThread;
        private static Button buttonStartAllOfThreads;

        private static Label labelOfFirstThread = new Label("Thread 1");
        private static Label labelOfSecondThread = new Label("Thread 2");
        private static Label labelOfThirdThread = new Label("Thread 3");
        private static Label labelOfDeletedElements = new Label("Deleted");
        private static Label labelWhichOutputSumOfHolding = new Label("Sum:");

        private static Text textOfCurrentHoldSum;

        public Elements() throws IOException {
            initialize();
        }

        public int getAbscissa() {
            return abscissa;
        }

        public XYChart.Series getSeries() {
            return series;
        }

        public void setSeries(XYChart.Series series) {
            this.series = series;
        }

        public void setAbscissa(int abscissa) {
            this.abscissa = abscissa;
        }

        public static Scene getScene() {
            return scene;
        }

        public static void setScene(Scene scene) {
            Elements.scene = scene;
        }

        public static VBox getvBoxOfFirstTable() {
            return vBoxOfFirstTable;
        }

        public static void setvBoxOfFirstTable(VBox vBoxOfFirstTable) {
            Elements.vBoxOfFirstTable = vBoxOfFirstTable;
        }

        public static VBox getvBoxOfSecondTable() {
            return vBoxOfSecondTable;
        }

        public static void setvBoxOfSecondTable(VBox vBoxOfSecondTable) {
            Elements.vBoxOfSecondTable = vBoxOfSecondTable;
        }

        public static VBox getvBoxOfThirdTable() {
            return vBoxOfThirdTable;
        }

        public static void setvBoxOfThirdTable(VBox vBoxOfThirdTable) {
            Elements.vBoxOfThirdTable = vBoxOfThirdTable;
        }

        public static VBox getvBoxOfOutTable() {
            return vBoxOfOutTable;
        }

        public static void setvBoxOfOutTable(VBox vBoxOfOutTable) {
            Elements.vBoxOfOutTable = vBoxOfOutTable;
        }

        public static VBox getvBoxOfTextAndChart() {
            return vBoxOfTextAndChart;
        }

        public static void setvBoxOfTextAndChart(VBox vBoxOfTextAndChart) {
            Elements.vBoxOfTextAndChart = vBoxOfTextAndChart;
        }

        public static HBox gethBoxOfThreeThreadsTables() {
            return hBoxOfThreeThreadsTables;
        }

        public static void sethBoxOfThreeThreadsTables(HBox hBoxOfThreeThreadsTables) {
            Elements.hBoxOfThreeThreadsTables = hBoxOfThreeThreadsTables;
        }

        public static HBox gethBoxOfTextAndButton() {
            return hBoxOfTextAndButton;
        }

        public static void sethBoxOfTextAndButton(HBox hBoxOfTextAndButton) {
            Elements.hBoxOfTextAndButton = hBoxOfTextAndButton;
        }

        public static HBox gethBoxContainerOfAllBoxes() {
            return hBoxContainerOfAllBoxes;
        }

        public static void sethBoxContainerOfAllBoxes(HBox hBoxContainerOfAllBoxes) {
            Elements.hBoxContainerOfAllBoxes = hBoxContainerOfAllBoxes;
        }

        public static TableView<Transaction> getTableViewOfFirstThread() {
            return tableViewOfFirstThread;
        }

        public static void setTableViewOfFirstThread(TableView<Transaction> tableViewOfFirstThread) {
            Elements.tableViewOfFirstThread = tableViewOfFirstThread;
        }

        public static TableView<Transaction> getTableViewOfSecondThread() {
            return tableViewOfSecondThread;
        }

        public static void setTableViewOfSecondThread(TableView<Transaction> tableViewOfSecondThread) {
            Elements.tableViewOfSecondThread = tableViewOfSecondThread;
        }

        public static TableView<Transaction> getTableViewOfThirdThread() {
            return tableViewOfThirdThread;
        }

        public static void setTableViewOfThirdThread(TableView<Transaction> tableViewOfThirdThread) {
            Elements.tableViewOfThirdThread = tableViewOfThirdThread;
        }

        public static TableView<Transaction> getTableViewOutFromList() {
            return tableViewOutFromList;
        }

        public static void setTableViewOutFromList(TableView<Transaction> tableViewOutFromList) {
            Elements.tableViewOutFromList = tableViewOutFromList;
        }

        public static LineChart<Number, Number> getLineChart() {
            return lineChart;
        }

        public static void setLineChart(LineChart<Number, Number> lineChart) {
            Elements.lineChart = lineChart;
        }

        public static Button getButtonStartFirstThread() {
            return buttonStartFirstThread;
        }

        public static void setButtonStartFirstThread(Button buttonStartFirstThread) {
            Elements.buttonStartFirstThread = buttonStartFirstThread;
        }

        public static Button getButtonStartSecondThread() {
            return buttonStartSecondThread;
        }

        public static void setButtonStartSecondThread(Button buttonStartSecondThread) {
            Elements.buttonStartSecondThread = buttonStartSecondThread;
        }

        public static Button getButtonStartThirdThread() {
            return buttonStartThirdThread;
        }

        public static void setButtonStartThirdThread(Button buttonStartThirdThread) {
            Elements.buttonStartThirdThread = buttonStartThirdThread;
        }

        public static Button getButtonStartAllOfThreads() {
            return buttonStartAllOfThreads;
        }

        public static void setButtonStartAllOfThreads(Button buttonStartAllOfThreads) {
            Elements.buttonStartAllOfThreads = buttonStartAllOfThreads;
        }

        public static Label getLabelOfFirstThread() {
            return labelOfFirstThread;
        }

        public static void setLabelOfFirstThread(Label labelOfFirstThread) {
            Elements.labelOfFirstThread = labelOfFirstThread;
        }

        public static Label getLabelOfSecondThread() {
            return labelOfSecondThread;
        }

        public static void setLabelOfSecondThread(Label labelOfSecondThread) {
            Elements.labelOfSecondThread = labelOfSecondThread;
        }

        public static Label getLabelOfThirdThread() {
            return labelOfThirdThread;
        }

        public static void setLabelOfThirdThread(Label labelOfThirdThread) {
            Elements.labelOfThirdThread = labelOfThirdThread;
        }

        public static Label getLabelOfDeletedElements() {
            return labelOfDeletedElements;
        }

        public static void setLabelOfDeletedElements(Label labelOfDeletedElements) {
            Elements.labelOfDeletedElements = labelOfDeletedElements;
        }

        public static Label getLabelWhichOutputSumOfHolding() {
            return labelWhichOutputSumOfHolding;
        }

        public static void setLabelWhichOutputSumOfHolding(Label labelWhichOutputSumOfHolding) {
            Elements.labelWhichOutputSumOfHolding = labelWhichOutputSumOfHolding;
        }

        public static Text getTextOfCurrentHoldSum() {
            return textOfCurrentHoldSum;
        }

        public static void setTextOfCurrentHoldSum(Text text) {
            Elements.textOfCurrentHoldSum = text;
        }

        public void initialize() throws IOException {
            series = new XYChart.Series();
            series.setName("Growth Monitoring");

            textOfCurrentHoldSum = new Text("0");
            textOfCurrentHoldSum.setTextAlignment(TextAlignment.LEFT);

            buttonStartFirstThread = new Button("Start");
            buttonStartFirstThread.setPrefSize(303, 50);

            buttonStartSecondThread = new Button("Start");
            buttonStartSecondThread.setPrefSize(303, 50);

            buttonStartThirdThread = new Button("Start");
            buttonStartThirdThread.setPrefSize(303, 50);

            buttonStartAllOfThreads = new Button("Start all");
            buttonStartAllOfThreads.setPrefSize(303, 50);

            lineChart = new LineChart<Number,Number>(new NumberAxis(), new NumberAxis());

            tableViewOfFirstThread = new TableView<>();
            fillTable(tableViewOfFirstThread, 400);

            tableViewOfSecondThread = new TableView<>();
            fillTable(tableViewOfSecondThread, 400);

            tableViewOfThirdThread = new TableView<>();
            fillTable(tableViewOfThirdThread, 400);

            tableViewOutFromList = new TableView<>();
            fillTable(tableViewOutFromList, 750);

            lineChart.getData().add(series);

            vBoxOfFirstTable = new VBox(14);
            vBoxOfFirstTable.setAlignment(Pos.CENTER);
            vBoxOfFirstTable.getChildren().addAll(labelOfFirstThread, tableViewOfFirstThread, buttonStartFirstThread);

            vBoxOfSecondTable = new VBox(14);
            vBoxOfSecondTable.setAlignment(Pos.CENTER);
            vBoxOfSecondTable.getChildren().addAll(labelOfSecondThread, tableViewOfSecondThread, buttonStartSecondThread);

            vBoxOfThirdTable = new VBox(14);
            vBoxOfThirdTable.setAlignment(Pos.CENTER);
            vBoxOfThirdTable.getChildren().addAll(labelOfThirdThread, tableViewOfThirdThread, buttonStartThirdThread);

            hBoxOfThreeThreadsTables =
                    new HBox(vBoxOfFirstTable.getWidth() + vBoxOfSecondTable.getWidth() + vBoxOfThirdTable.getWidth());
            hBoxOfThreeThreadsTables.setAlignment(Pos.CENTER);
            hBoxOfThreeThreadsTables.setSpacing(14d);
            hBoxOfThreeThreadsTables.getChildren().addAll(vBoxOfFirstTable, vBoxOfSecondTable, vBoxOfThirdTable);

            hBoxOfTextAndButton = new HBox(14);
            hBoxOfTextAndButton.setAlignment(Pos.CENTER_LEFT);
            hBoxOfTextAndButton.setSpacing(14d);
            hBoxOfTextAndButton.getChildren()
                    .addAll(buttonStartAllOfThreads, labelWhichOutputSumOfHolding, textOfCurrentHoldSum);

            vBoxOfTextAndChart = new VBox(14);
            vBoxOfTextAndChart.setAlignment(Pos.CENTER);
            vBoxOfTextAndChart.getChildren().addAll(hBoxOfThreeThreadsTables, hBoxOfTextAndButton, lineChart);

            vBoxOfOutTable = new VBox(14);
            vBoxOfOutTable.setAlignment(Pos.CENTER);
            vBoxOfOutTable.getChildren().addAll(labelOfDeletedElements, tableViewOutFromList);

            hBoxContainerOfAllBoxes = new HBox(14);
            hBoxContainerOfAllBoxes.getChildren().addAll(vBoxOfTextAndChart, vBoxOfOutTable);

        }

        private void fillTable(TableView<Transaction> table, int maxHeight) throws IOException {
            table.setPrefHeight(maxHeight);
            table.setMinHeight(maxHeight);
            table.setMaxHeight(maxHeight);

            //value column
            TableColumn<Transaction, Long> valueColumn = new TableColumn<>("Value");
            valueColumn.setMinWidth(150);
            valueColumn.setMaxWidth(150);
            valueColumn.setCellValueFactory(new PropertyValueFactory<>("valueOfTransaction"));

            //timeBorder column
            TableColumn<Transaction, Double> timeBorderColumn = new TableColumn<>("Time");
            timeBorderColumn.setMinWidth(150);
            timeBorderColumn.setMaxWidth(150);
            timeBorderColumn.setCellValueFactory(new PropertyValueFactory<>("incomeTime"));
            timeBorderColumn.setCellValueFactory(transactionLongCellDataFeatures -> new ReadOnlyObjectWrapper<>(
                    (System.currentTimeMillis() - transactionLongCellDataFeatures.getValue().getIncomeTime()) / 1000d
            ));

            table.getColumns().addAll(valueColumn, timeBorderColumn);
            table.setMaxWidth(valueColumn.getMaxWidth() + timeBorderColumn.getMaxWidth());
        }
       }

    public static Elements getElements() {
        return elements;
    }

    public static void setElements(Elements elements) {
        View.elements = elements;
    }

    public View() throws IOException {
        elements = new Elements();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Elements.setScene(new Scene(Elements.gethBoxContainerOfAllBoxes(), 1280, 800));
        stage.setScene(Elements.getScene());
        stage.setResizable(false);
        stage.setTitle("Title of my application");
        stage.show();
    }
}
