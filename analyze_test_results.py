import xml.etree.ElementTree as ET
import pandas as pd

def analyze_test_results(file_path):
    tree = ET.parse(file_path)
    root = tree.getroot()

    test_cases = []
    for suite in root.findall('.//suite'):
        for test in suite.findall('.//test'):
            for class_ in test.findall('.//class'):
                for test_method in class_.findall('.//test-method'):
                    status = test_method.get('status')
                    name = test_method.get('name')
                    description = test_method.get('description', 'No description')
                    exceptions = test_method.findall('.//exception')
                    messages = [exception.find('message').text if exception.find('message') is not None else "No message"
                                for exception in exceptions]
                    test_cases.append({
                        'Test Name': name,
                        'Status': status,
                        'Description': description,
                        'Messages': "; ".join(messages) if messages else "No messages"
                    })

    df = pd.DataFrame(test_cases)

    passed = df[df['Status'] == 'PASS'][['Test Name', 'Status', 'Description']]  
    failed = df[df['Status'] == 'FAIL']  


    passed.to_csv('passed_tests.csv', index=False)
    failed.to_csv('failed_tests.csv', index=False)

if __name__ == "__main__":
    import sys
    analyze_test_results(sys.argv[1])
