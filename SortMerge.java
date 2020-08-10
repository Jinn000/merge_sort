package ru.zav.labs.sort.merge;

import java.util.Arrays;

public class SortMerge {
	private static void merge(int[] arr, int start, int middle, int end) {
		if(end < start || end < middle || start > middle) 
			throw new IllegalArgumentException(new StringBuilder()
				.append("��������� �� ������, �������� � ����� ������� ������� �� ��������� ->")
				.append(" Start:" + start)
				.append(" Middle:" + middle)
				.append(" End:" + end)
				.toString());
		
		//��������� �� ������ ����� � ������ �������
		int p = start;
		int q = middle +1;
		
		//�������� ����������� ������ ��������� �������
		int len = end - start + 1;
		int[] buf = new int[len];
		
		//������� �� ����� ���������, � ������� �������� �������� � �����
		for(int i = 0; i < len; i++) {
			
			if (p <= middle && q <= end){
				//���� ��������� ����� � ������ �������� �� �������� �������
	            if (arr[p] < arr[q]){
	                buf[i] = arr[p];
	                p++;
	            }
	            else {
	                buf[i] = arr[q];
	                q++;
	            }
	        }
	        else if (p <= middle) {
	            buf[i] = arr[p];
	            p++;
	        }
	        else {
	            buf[i] = arr[q];
	            q++;
	        }
		}
		
		//��������� �� ������ � ������� ������
		for(int i = 0; i < len; i++) {
			arr[start + i] = buf[i];
		}
	}
	public static void sort(int[] arr, int start, int end) throws IllegalArgumentException {
		if(end < start) throw new IllegalArgumentException("��������� �� ������ ������� ������ ��������� �� ����� -> Start:" + start + " End:" + end);
		if(end == start) return;
		// ������ �������� ������� (� ����������� � ������� �������)
		int mid = Math.floorDiv(end - start, 2) + start;
		
		//���������� ������� ���������� � ����� ��������� �������
		sort(arr, start, mid);
		sort(arr, mid+1, end);
		
		//������� ������� � �����������
		merge(arr, start, mid, end);
	}
	
	
	public static void main(String[] args) {
		int[] testArray = {16,3,8,7,12,1,101,100,100,0,-4,-2,-3};
		
		switch (testArray.length) {
		case 0:
			System.out.println("������� ������ ����");
			return;
		case 1:
			System.out.println(Arrays.toString(testArray));
			return;
		}
		
		int startIndex = 0;
		try {
			sort(testArray, startIndex, testArray.length - 1);
			
			System.out.println(Arrays.toString(testArray));
		} catch (IllegalArgumentException e) {
			System.out.println(new StringBuilder("���������� ��������� ����������. �� ������ ���������: ")
									.append(startIndex)
									.append("; ")
									.append(testArray.length));
		}
		
	}
	
}
