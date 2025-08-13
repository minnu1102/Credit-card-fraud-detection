# Credit Card Fraud Detection

## Project Overview
This project focuses on detecting fraudulent credit card transactions using machine learning techniques. The primary goal was to improve the model's ability to correctly identify fraudulent activities (recall) without generating too many false alarms.

## Problem Statement
Financial institutions face significant losses due to fraudulent transactions. Detecting fraud in real time is challenging due to the severe class imbalance in transaction data, where genuine transactions heavily outnumber fraudulent ones.

## Objectives
- Build an efficient ML pipeline to classify transactions as fraudulent or genuine.
- Handle data imbalance without losing valuable patterns.
- Improve recall while keeping false positives minimal.

## Dataset
- Source: Public credit card transaction dataset with 284,807 transactions.
- Features: Anonymized numerical variables from PCA transformation, transaction amount, and class label.
- Class Distribution: Highly imbalanced with <0.2% fraud cases.

## Methodology
1. Data preprocessing and exploration to understand distributions.
2. Applied SMOTE to oversample the minority (fraud) class.
3. Reduced feature dimensions using PCA to speed up training.
4. Implemented XGBoost for classification due to its high performance on tabular data.
5. Applied K-Means clustering to segment customers based on transaction patterns.

## Results
- Recall improved from 72% to 86%.
- Maintained strong precision while reducing false positives.
- Visualized feature importance and confusion matrix for evaluation.

## Tech Stack
Python, Pandas, NumPy, Scikit-learn, SMOTE, PCA, XGBoost, K-Means, Matplotlib, Seaborn

## Future Enhancements
- Implement real-time streaming fraud detection using Apache Kafka.
- Experiment with anomaly detection models for unsupervised scenarios.
- Deploy model as a microservice with monitoring.
