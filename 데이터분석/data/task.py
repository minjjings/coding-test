import pandas as pd
import numpy as np

# CSV 파일 경로 설정
file_path = "C:/브릭_노민경/데이터분석/data/sample.csv"  # 실제 파일 경로로 변경

# CSV 파일 읽어오기
df = pd.read_csv(file_path, header=None)

# 숫자만 포함된 행 필터링 함수
def is_all_numbers(row):
    return row.apply(lambda x: isinstance(x, (int, float)) and not np.isnan(x)).all()

# 숫자만 포함된 행 필터링
valid_rows = df[df.apply(is_all_numbers, axis=1)]

# 계산 함수
def calculate_statistics(row):
    min_val = row.min()
    max_val = row.max()
    total_sum = row.sum()
    mean = row.mean()
    std_dev = row.std()
    median = row.median()
    
    return pd.Series({
        'Min': min_val,
        'Max': max_val,
        'Sum': total_sum,
        'Mean': mean,
        'Std Dev': std_dev,
        'Median': median
    })

# 각 행에 대해 계산 수행
result = valid_rows.apply(calculate_statistics, axis=1)

# 결과 출력
print("Calculated results:")
print(result)

# 계산이 안된 (즉, 숫자가 아닌 값이 포함된) 행들만 추출
error_rows = df[~df.apply(is_all_numbers, axis=1)]

# 오류가 있는 값들 출력
print("\nError values:")
print(error_rows)

# 총 행 수와 계산된 행 수 출력
print("\nThe total number of lines:", len(df))
print("The calculated lines:", len(valid_rows))
print("The error values:", len(error_rows))
